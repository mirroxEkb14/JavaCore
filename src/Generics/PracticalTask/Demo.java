package Generics.PracticalTask;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alejandro", 9));
        studentList.add(new Student("Anna", 7));
        studentList.add(new Student("Nikolas", 10));
        studentList.add(new Student("Juan", 6));

        Set<Student> studentSet = new TreeSet<>(new StudentComparator().reversed());
        studentSet.addAll(studentList);

        System.out.println(studentSet);
    }
}
