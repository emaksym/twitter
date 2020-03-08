package pl.sda.twitter.exceptions;

public class IncorrectLoginOrPasswordException extends Exception {
    public IncorrectLoginOrPasswordException (String message){
        super(message);
    }
}
