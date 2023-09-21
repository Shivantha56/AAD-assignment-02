package lk.ijse.gdse.globaltechapi.exception;

public class NotFoundException extends RuntimeException{

    private String message;

    public NotFoundException(String message) {
        super(message);
    }


    public String getNotFoundMessage() {
        return message;
    }
}
