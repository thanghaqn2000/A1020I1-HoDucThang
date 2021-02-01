package abstract_class_interface.bai_tap.colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0]=new Circle(3);
        shapes[1]=new Square(5);
        shapes[2]=new Rectangle(5,7);
        for (Shape shape : shapes){
            if(shape instanceof Colorable){
                if(shape instanceof Square)
                    System.out.println("Diện tích hình vuông: "+((Square)shape).getArea());
                else if(shape instanceof Circle)
                    System.out.println("Diện tích hình tròn: "+((Circle)shape).getArea());
                else if(shape instanceof Rectangle)
                    System.out.println("Diện tích hình chữ nhật: "+((Rectangle)shape).getArea());
               Colorable colorable = (Colorable) shape;
               colorable.howToColor();
            }
        }
    }
}
