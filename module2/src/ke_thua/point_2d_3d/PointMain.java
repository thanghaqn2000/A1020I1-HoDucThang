package ke_thua.point_2d_3d;

public class PointMain {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        Point3D point3D=new Point3D();
        point3D.setXYZ(4,5,6);
        for (int i=0;i<point3D.getXYZ().length;i++){
            System.out.println(point3D.getXYZ()[i]);
        }
        point2D.setXY(2, 3);
        for (int i=0;i<point2D.getXY().length;i++){
            System.out.println(point2D.getXY()[i]);
        }
    }
}
