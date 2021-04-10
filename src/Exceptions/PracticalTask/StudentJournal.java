package Exceptions.PracticalTask;

import java.util.ArrayList;
import java.util.List;

public class StudentJournal {

    private static List<Student> students = new ArrayList<>();

    public static void add(Student student) {
        students.add(student);
    }
}
