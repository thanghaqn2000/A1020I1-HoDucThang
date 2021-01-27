package ke_thua.moveablepoint_point;

public class PointMain {
    public static void main(String[] args) {
        MoveablePoint moveablePoint=new MoveablePoint(1,2,3,4);
        for (int i=0;i<moveablePoint.getSpeed().length;i++){
            System.out.println(moveablePoint.getSpeed()[i]);
        }
        System.out.println( moveablePoint.move());
        Point point=new Point(5.3f,5);
        System.out.println(point.toString());
    }
}
