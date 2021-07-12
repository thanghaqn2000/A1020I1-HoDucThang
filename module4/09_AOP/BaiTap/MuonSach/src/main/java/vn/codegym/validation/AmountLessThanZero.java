package vn.codegym.validation;

public class AmountLessThanZero extends Exception{
    @Override
    public String getMessage() {
        return "Số lượng sách cần mượn đã hết";
    }
}
