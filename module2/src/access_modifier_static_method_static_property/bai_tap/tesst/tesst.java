package access_modifier_static_method_static_property.bai_tap.tesst;

import access_modifier_static_method_static_property.bai_tap.access_modifer.Circle;

 class test extends Circle {
    public static void main(String[] args) {
        Circle c1=new Circle();
        System.out.println(c1.getColor());
        //System.out.println(c1.getRadius()); ko the truy cap toi getRadius mac duf da extends
    }
}
