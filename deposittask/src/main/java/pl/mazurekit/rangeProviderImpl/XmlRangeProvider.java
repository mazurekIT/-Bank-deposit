package pl.mazurekit.rangeProviderImpl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pl.mazurekit.Range;
import pl.mazurekit.RangeProvider;
import pl.mazurekit.RangesReadException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XmlRangeProvider implements RangeProvider {
    private String filePath;
    private static final String UNIT_NAME_FOR_RANGE_FROM = "kwota_od";
    private static final String UNIT_NAME_FOR_RANGE_TO = "kwota_do";
    private static final String UNIT_NAME_FOR_INTEREST = "oprocentowanie";

    public XmlRangeProvider(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Range> getAvailableRanges() {
        List<Range> ranges = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(filePath));
            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("range");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String rangeFrom = element.getElementsByTagName(UNIT_NAME_FOR_RANGE_FROM).item(0).getTextContent();
                    String rangeTo = element.getElementsByTagName(UNIT_NAME_FOR_RANGE_TO).item(0).getTextContent();
                    String interest = element.getElementsByTagName(UNIT_NAME_FOR_INTEREST).item(0).getTextContent();
                    ranges.add(new Range(
                            convertStringToBigDecimal(rangeFrom),
                            convertStringToBigDecimal(rangeTo),
                            convertStringToBigDecimal(interest)
                    ));
                }
            }
            return ranges;

        } catch (ParserConfigurationException e) {
            throw new RangesReadException("Błąd parsowania w pliku XML", e);
        } catch (SAXException | IOException e) {
            throw new RangesReadException("Błędna ścieżka pliku XML", e);
        }
    }


    private BigDecimal convertStringToBigDecimal(String number) {
        return new BigDecimal(Double.parseDouble(number));
    }
}
