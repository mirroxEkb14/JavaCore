package Stream.Tasks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTask {

    /**
     * найти студентов с уникальными предметами
     */

    public static void main(String[] args) {
        Student stud1 = new Student("John", Arrays.asList("Math", "Chemistry"));
        Student stud2 = new Student("Peter", Arrays.asList("Math", "History"));
        Student stud3 = new Student("Antony", Arrays.asList("Music", "History", "English"));

        Stream<Student> studentStream = Stream.of(stud1, stud2, stud3);

        studentStream
                .flatMap(s -> s.getSubjects().stream()
                        .map(subj -> new AbstractMap.SimpleEntry<>(subj, s)))
                .collect(Collectors.groupingBy(Map.Entry::getKey))
                .entrySet().stream()
                .filter(e -> e.getValue().size() == 1)
                .map(e -> e.getValue().get(0).getValue().getName())
                .collect(Collectors.toSet())
                .forEach(System.out::println);

/*
    flatMap       map                                         collect
    Math          Math=Stream.Tasks.Student@34c45dca          English=[English=Stream.Tasks.Student@312b1dae]
    Chemistry     Chemistry=Stream.Tasks.Student@34c45dca     Chemistry=[Chemistry=Stream.Tasks.Student@7530d0a]
    Math          Math=Stream.Tasks.Student@5b6f7412          Music=[Music=Stream.Tasks.Student@312b1dae]
    History       History=Stream.Tasks.Student@5b6f7412       History=[History=Stream.Tasks.Student@27bc2616, History=Stream.Tasks.Student@312b1dae]
    Music         Music=Stream.Tasks.Student@27973e9b         Math=[Math=Stream.Tasks.Student@7530d0a, Math=Stream.Tasks.Student@27bc2616]
    History       History=Stream.Tasks.Student@27973e9b
    English       English=Stream.Tasks.Student@27973e9b

    filter                                                 map        collect
    English=[English=Stream.Tasks.Student@312b1dae]        Antony     John
    Chemistry=[Chemistry=Stream.Tasks.Student@7530d0a]     John       Antony
    Music=[Music=Stream.Tasks.Student@312b1dae]            Antony
*/
    }
}

class Student {
    private String name;
    private List<String> subjects;

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