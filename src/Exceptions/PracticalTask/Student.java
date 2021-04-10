package Exceptions.PracticalTask;

public class Student {

    private String name;
    private int grade;

    public Student(String name, int grade) throws IllegalValueException {

        if (name == null) {
            throw new IllegalValueException("Illegal argument: " + null);
        }

        this.name = name;
        this.grade = grade;
    }
}
