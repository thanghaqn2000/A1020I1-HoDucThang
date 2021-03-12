package furama_resorts.common.exception.user_exception;

public class BirthdayException extends UserException {
    public BirthdayException() {
        super("Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy");
    }

    public BirthdayException(String msg) {
        super(msg);
    }
}
