package JavaTasks.Different;

import java.util.*;

public class StudentTask {

    /**
     * найти студентов с уникальными предметами
     */

    public static void main(String[] args) {
        Student stud1 = new Student("John", Arrays.asList("Math", "Chemistry"));
        Student stud2 = new Student("Peter", Arrays.asList("Math", "History"));
        Student stud3 = new Student("Antony", Arrays.asList("Music", "History", "English"));

        Map<String, List<String>> map = new HashMap<>();

        List<Student> students = List.of(stud1, stud2, stud3);
        for (Student student: students) {
            for (int i = 0; i < student.getSubjects().size(); i++) {
                String key = student.getSubjects().get(i);

                if (map.containsKey(key)) {
//                    List<String> oldValues = new ArrayList<>(map.get(key));
//                    oldValues.add(student.getName());
//
//                    map.replace(key, map.get(key), oldValues);

                    map.remove(key);

                } else {
                    map.put(key, List.of(student.getName()));
                }
            }
        }
        System.out.println(map.values());

        Set<String> uniqueStudents = new HashSet<>();
        for (List<String> listName: map.values()) {
            uniqueStudents.add(listName.get(0));
        }
        System.out.println(uniqueStudents); // [John, Antony]
    }
}

class Student {
    private final String name;
    private final List<String> subjects;

    public Student(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjects() {
        return subjects;
    }
}