package toucan.exceptions;

/**
 * Created by Cyril on 22/12/2017.
 */
public abstract class ToucanException extends RuntimeException {
    public ToucanException(String s) {
        super(s);
    }
}
