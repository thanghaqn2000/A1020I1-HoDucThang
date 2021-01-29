package abstract_class_interface.thuc_hanh.animal_edibe;

public class Chicken extends Animal implements Edibe {

    @Override
    public String makeSound() {
        return "cuc tac , cuc tac";
    }

    @Override
    public String howtoEat() {
        return "mo thuc an";
    }

}
