package FunctionalInterfaces;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        /* takes 1 argument and returns true-false  */

        Predicate<Integer> predicate1 = x -> x > 5;
        System.out.println(predicate1.test(3)); // false

        Predicate<String> predicate2 = str -> str.startsWith("s");
        System.out.println(predicate2.test("startSTR"));
    }
}
