package edu.ucsd.cse218;

/**
 * Created with IntelliJ IDEA.
 * User: tripodduan
 */
public class PreconditionViolatedException extends AssertionError {
    public PreconditionViolatedException(){
        super();
    }
    public PreconditionViolatedException(String detailMessage){
        super(detailMessage);
    }
}
