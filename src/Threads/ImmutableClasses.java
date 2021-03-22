package Threads;

import java.util.Date;

public class ImmutableClasses {
    public static void main(String[] args) {
        Student student = new Student(19, "Bob", new Date());

        System.out.println(student.getAge());
        System.out.println(student.getName());
        System.out.println(student.getDate());
    }
}

final class Student {
    private final int age;
    private final String name;
    private final Date date;

    public Student(int age, String name, Date date) {
        this.age = age;
        this.name = name;
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}