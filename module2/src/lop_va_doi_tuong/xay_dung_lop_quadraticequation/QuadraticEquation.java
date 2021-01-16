package lop_va_doi_tuong.xay_dung_lop_quadraticequation;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        double delta = (this.b * this.b) - (4 * this.a * this.c);
        return delta;
    }

    public double getRoot1() {
        double x1 = ((this.b * -1) + Math.pow(this.b*this.b-4*this.a*this.c,0.5))/2*this.a;
        return x1;
    }

    public double getRoot2() {
        double x2 = ((this.b * -1) - Math.pow(this.b*this.b-4*this.a*this.c,0.5))/2*this.a;
        return x2;
    }

}
