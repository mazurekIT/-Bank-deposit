public class FilePathNotFoundException extends Exception {

    public FilePathNotFoundException() {
    }

    public FilePathNotFoundException(String message) {
        super(message);
    }

    public FilePathNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
