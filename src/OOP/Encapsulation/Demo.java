package OOP.Encapsulation;

public class Demo {

    public static void main(String[] args) {
        Person person = new Person();
        Animal animal = new Animal();

        /*  Without encapsulation we refer to the fields of the class directly  */
        person.name = "some name";
        person.age = 21;

        /*  Moreover, we can make age negative or leave name blank, that is wrong  */
        person.name = "";
        person.age = -5;

        /*  Encapsulation is "Setters and Getters", it is methods through which we can refer to
                the fields of the class, plus we can make checks in these methods, so some user
                will not be able to enter a negative age or blank name

                *see the "Animal" class  */

        animal.setId(1);
        animal.getId();

    }
}
