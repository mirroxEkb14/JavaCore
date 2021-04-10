package Exceptions.PracticalTask;

public class StudentRunner {

    public static void main(String[] args) {

        try {
            // create and add a student to the journal
            StudentJournal.add(new Student(null, 5));

        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }
}
