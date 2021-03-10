package furama_resorts.common.exception.user_exception;

public class GenderException extends Exception {
    public GenderException(){
        super("Không đúng định dạng nam hoặc nữ");
    }
    public GenderException(String msg){
        super(msg);
    }
}
