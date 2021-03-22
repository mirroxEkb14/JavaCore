package OOP;

public class EncapsulationJava {

    public static void main(String[] args) {
        Person person = new Person();
        Animal1 animal = new Animal1();

        /*  Without encapsulation we refer to the fields of the class directly  */
        person.name = "some name";
        person.age = 21;

        /*  Moreover, we can make age negative, or leave name blank, that is wrong  */
        person.name = "";
        person.age = -5;

        /*  Encapsulation is "Setter and Getters", it is methods through which we can refer to
                the fields of the class, plus we can make checks in these methods, so some user
                will not be able to enter a negative age or blank name

                *see the "Animal" class  */

        animal.setId(1);
        animal.getId();

    }
}

class Animal1 {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 1) { // check the ID
            throw new IllegalArgumentException();
        }
        this.id = id;
    }
}

class Person {
    String name;
    int age;
}