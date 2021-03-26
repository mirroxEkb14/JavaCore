package OOP.PracticalTask;

public class Person {

    private String name;
    private String profession;
    private int age;

    public Person(String name, String profession, int age) {
        this.name = name;
        this.profession = profession;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void doWork() {
        System.out.println("I am a person and I am working!");
    }
}
