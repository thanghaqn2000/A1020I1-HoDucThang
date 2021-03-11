package ExceptionDebug.IllegalTriangleException;

public class IllegalTriangleException extends Exception {

    public IllegalTriangleException() {
        super("Lỗi cạnh bé hơn 0");
    }
    public IllegalTriangleException(String msg) {
        super(msg);
    }

}
