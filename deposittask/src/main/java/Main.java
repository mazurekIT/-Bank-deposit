import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world");

        Lokata lokata = new Lokata();
        System.out.println(lokata.zyskRoczny(new BigDecimal(25001)));

    }
}
