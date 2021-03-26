package OOP.Polymorphism;

public class Demo {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();

        /*  Polymorphism is that we have different realizations of one method,
                the "sleep()" method is in the parent class but we can override this method
                in the child class, so we have one method but two realizations  */
        animal.sleep(); // Animal is sleeping
        dog.sleep(); // Dog is sleeping
    }
}
