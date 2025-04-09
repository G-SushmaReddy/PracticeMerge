package customExceptions;

public class NoBrowserFoundException extends RuntimeException{

    public NoBrowserFoundException()
    {
        super("The browser you are trying to access is not available");
    }
}
