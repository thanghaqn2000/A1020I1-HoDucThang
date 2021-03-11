package exception_debug.IllegalTriangleException;

public class Triangle{
    double canh1;
    double canh2;
    double canh3;

    public Triangle() {
    }

    public Triangle(double canh1, double canh2, double canh3) throws IllegalTriangleException {
        this.canh1 = canh1;
        this.canh2 = canh2;
        this.canh3 = canh3;
        if(canh1<0||canh2<0||canh3<0){
            throw new IllegalTriangleException("Lỗi cạnh bé hơn 0");
        }else if(canh1+canh2<canh3||canh1+canh3<canh2||canh2+canh3<canh1){
            throw new IllegalTriangleException("Tổng hai cạnh ko lớn hơn cạnh còn lại");
        }
    }

    public double getCanh1() {
        return canh1;
    }

    public void setCanh1(double canh1) {
        this.canh1 = canh1;
    }

    public double getCanh2() {
        return canh2;
    }

    public void setCanh2(double canh2) {
        this.canh2 = canh2;
    }

    public double getCanh3() {
        return canh3;
    }

    public void setCanh3(double canh3) {
        this.canh3 = canh3;
    }

}
