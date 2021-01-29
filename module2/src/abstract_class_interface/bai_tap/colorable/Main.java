package abstract_class_interface.bai_tap.colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0]=new Circle(3);
        shapes[1]=new Square(5);
        shapes[2]=new Rectangle(5,7);
        for (Shape shape : shapes){
            if(shape instanceof Colorable){
                //System.out.println("Diện tích hình tròn: "+((Square) shape).getArea());
               Colorable colorable = (Colorable) shape;
               colorable.howToColor();
            }
        }
    }
}
