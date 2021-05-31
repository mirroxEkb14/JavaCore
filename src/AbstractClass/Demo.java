package AbstractClass;

public class Demo {
    public static void main(String[] args) {
        Animal animal1 = new Cat();
        Animal animal2 = new Dog();

        animal1.makeSound();
        animal1.eat();

        animal2.makeSound();
        animal2.eat();
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("bark");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("meow");
    }
}

abstract class Animal {
    /*  When we cannot create class object  */

    public void eat() {
        System.out.println("I am eating...");
    }

    public abstract void makeSound();
}