package furama_resorts.models;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FilingCabinets {
    private static Stack<Employee> stack=new Stack<>();

    public FilingCabinets() {
    }
    public void add(Employee employee){
        stack.push(employee);
    }
    public Queue<Employee> search(String name){
        Queue<Employee> listEmp=new LinkedList<>();
        for (Employee emp:stack) {
            if(emp.getNameEmp().toLowerCase().contains(name.toLowerCase()))
                listEmp.add(emp);
        }
        if(listEmp.isEmpty())
            return null;
        else
            return listEmp;
    }
}
