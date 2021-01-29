package abstract_class_interface.thuc_hanh.animal_edibe;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound()) ;
            if(animal instanceof Chicken){
                Edibe edibe= (Chicken)animal;
                //Chicken edibe2= (Chicken)animal;
                System.out.println(edibe.howtoEat());
            }
        }
        Fruit[] fruits=new Fruit[2];
        fruits[0]=new Apple();
        fruits[1]=new Orange();
        for (Fruit fruit: fruits){
            //System.out.println(fruit.howtoEat());
            if(fruit instanceof Apple){
                System.out.println(fruit.howtoEat());
            }
        }
    }
}
