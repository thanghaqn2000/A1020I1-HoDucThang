package test;

import java.util.ArrayList;
import java.util.List;
public class Main {
public static final String COMMON=",";
    public static void main(String[] args) {
        QuadraticEquation o1 = new QuadraticEquation(2, "a1", "a2");
        List<QuadraticEquation> equations = new ArrayList<>();
        equations.add(o1);
        String line = null;
        for (QuadraticEquation quadraticEquation : equations) {
            line= o1.getA() +COMMON+ o1.getB() +COMMON +o1.getC();
            Input_Output.writeFile("E:/sv.txt",line);
        }
        List<String> list=Input_Output.readFile("E:/sv.txt");
        System.out.println(list);
    }
}
