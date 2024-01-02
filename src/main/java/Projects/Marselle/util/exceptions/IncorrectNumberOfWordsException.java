package Projects.Marselle.util.exceptions;

public class IncorrectNumberOfWordsException extends Exception {
    private final String message;
    public IncorrectNumberOfWordsException() {
        this.message = "Incorrect number of words entered";
    }
}
