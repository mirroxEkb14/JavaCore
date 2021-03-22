package Interfaces;

public class Test1 {
    public static void main(String[] args) {
        Animal animal = new Animal(1);
        Person person = new Person("Bob");

//        animal.showInfo();
//        person.showInfo();

        outputInfo(animal);
        outputInfo(person);
    }

    public static void outputInfo(Info info) {
        info.showInfo();
    }
}

interface Info {
    void showInfo();
}

class Person implements Info{
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("Person`s name: " + name);
    }
}

class Animal implements Info {
    int id;

    public Animal(int id) {
        this.id = id;
    }

    public void showInfo() {
        System.out.println("Animal`s id: " + id);
    }
}