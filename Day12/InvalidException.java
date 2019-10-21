/**
 * This is a user defined class that throws an Exception
 *  to the user when the user created an object to this class.
 * 
 * @author Siva Sankar
 */

public class InvalidException extends Exception {

    public static final long serialVersionUID = 1L;
    private String ExpMessage;

    /**
     * This is a constructor used to construct the 
     * InvalidIndexException. This calls the super class constructor
     * which is an Exception used to set the message (String variable)
     * in the super class.
     * 
     * @param message to be set to super class's message.
     */
    public InvalidException(String message) {
        super(message);
        ExpMessage=message;
    }
    public String getMessage(){
        return ExpMessage;
    }
    
}