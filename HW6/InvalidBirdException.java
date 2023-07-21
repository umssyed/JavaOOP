/**
 * Collaboration Statement
 * I worked on the homework assignment alone, using only course materials.
 */


/**
 * This class represents a InvalidBirdException class
 * @author Muhammad Uzair Shahid Syed
 * @version 1.0
 */

public class InvalidBirdException extends RuntimeException {

    /**
     * Constructor with no args
     */
    public InvalidBirdException() {
        super("Your bird is invalid!");
    };

    /**
     * Constructor with 1-arg String
     * @param s String
     */
    public InvalidBirdException(String s) {
        super(s);
    }

    /*
     * Method to get message
     */
    public String getMessage() {
        return super.getMessage();
    }

}
