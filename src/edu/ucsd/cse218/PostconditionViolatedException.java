package edu.ucsd.cse218;

/**
 * Created with IntelliJ IDEA.
 * User: tripodduan
 */
public class PostconditionViolatedException extends AssertionError {
    public PostconditionViolatedException(){
        super();
    }
    public PostconditionViolatedException(String detailMessage){
        super(detailMessage);
    }
}
