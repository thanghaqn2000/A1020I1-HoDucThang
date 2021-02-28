package stack_queue.demegring;

import access_modifier_static_method_static_property.thuc_hanh.static_method.Student;

import java.util.Comparator;

public class CompareBirthDay implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human human2) {
        int result = human1.getGender().compareTo(human2.getGender());
        if (result == 0){
            return human1.getDateOfBirth().compareTo(human1.getDateOfBirth());
        } else return result;
    }
}
