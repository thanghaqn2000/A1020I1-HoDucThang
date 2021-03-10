package furama_resorts.common.exception.user_exception;

public class IdCardException extends Exception{
    public IdCardException(){
        super("Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX");
    }
    public IdCardException(String msg){
        super(msg);
    }
}
