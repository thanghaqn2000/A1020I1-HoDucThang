package abstract_class_interface.bai_tap.resizeable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0]=new Circle(3);
        shapes[1]=new Rectangle(3,4);
        shapes[2]=new Square(4);
        double resizePercent = Math.random() * 100;
        resizePercent=Math.round(resizePercent);
        System.out.println("Phần trăm mỗi hình : "+resizePercent+"%");
        for (Shape shape: shapes){
            if(shape instanceof Circle){
                System.out.println("Diện tích hình tròn ban đầu "+((Circle) shape).getArea());
                ((Circle) shape).resize(resizePercent);
                System.out.println("Diện tích hình tròn sau khi tăng là  "+((Circle) shape).getArea());
            }else if(shape instanceof Rectangle){
                System.out.println("Diện tích hình chữ nhật ban đầu "+((Rectangle) shape).getArea());
                ((Rectangle) shape).resize(resizePercent);
                System.out.println("Diện tích hình tròn sau khi tăng là "+((Rectangle) shape).getArea());
            }else if(shape instanceof Square){
                System.out.println("Diện tích hình tròn ban đầu  "+((Square) shape).getArea());
                ((Square) shape).resize(resizePercent);
                System.out.println("Diện tích hình tròn sau khi tăng  là  "+((Square) shape).getArea());
            }
        }
    }
}
