package stack_queue.demegring;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Demegering {
    public static void main(String[] args) {
        Queue<Human> queueFemale = new LinkedList<>();
        Queue<Human> queueMale = new LinkedList<>();
        LinkedList<Human> humanList = new LinkedList<>();
        Human human1 = new Human("Nam", "male", "01/01/1991");
        Human human2 = new Human("Dat", "male", "01/05/1992");
        Human human3 = new Human("Huong", "female", "03/09/2003");
        Human human4 = new Human("Ngoc", "female", "04/05/2004");
        Human human5 = new Human("Hung", "male", "02/04/2005");
        Human human6 = new Human("Ha", "female", "04/03/2006");
        humanList.add(human1);
        humanList.add(human2);
        humanList.add(human3);
        humanList.add(human4);
        humanList.add(human5);
        humanList.add(human6);
        Collections.sort(humanList);
        while (!humanList.isEmpty()) {
            Human student = humanList.remove();
            if (student.getGender().equals("female")) {
                queueFemale.add(student);
            } else {
                queueMale.add(student);
            }
        }
        while (!queueFemale.isEmpty()) {
            humanList.add(queueFemale.remove());
        }
        while (!queueMale.isEmpty()) {
            humanList.add(queueMale.remove());
        }
        In_Out.writeHumansToCSV(humanList, In_Out.HUMAN_PATH);
        System.out.println("done");
    }
}
