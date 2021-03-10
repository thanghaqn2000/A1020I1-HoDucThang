package furama_resorts.common.exception.user_exception;

public class EmailException extends Exception {
    public EmailException(){
        super("Email phải đúng định dạng abc@abc.abc");
    }
    public EmailException(String msg){
        super(msg);
    }
}
