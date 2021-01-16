package lop_va_doi_tuong.xay_dung_lop_quadraticequation;

public class QuadraticEquationMain {
    public static void main(String[] args) {
        QuadraticEquation ptb2 = new QuadraticEquation(0, 0, 4);
        if (ptb2.getA() == 0) {
            if (ptb2.getB() == 0) {
                System.out.println("Phương trình có vô số nghiệm");
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        } else {
            if (ptb2.getDiscriminant() > 0) {
                System.out.printf("Phương trình có 2 nghiệm , x1= %f và x2= %f", ptb2.getRoot1(), ptb2.getRoot2());
            } else if (ptb2.getDiscriminant() == 0) {
                System.out.printf("Phương trình có 1 nghiệm x= %f", (ptb2.getB() * -1) / ptb2.getA());
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        }
    }
}
