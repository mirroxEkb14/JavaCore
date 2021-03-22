package FunctionalInterfaces;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        /*  takes 1 argument and returns a different
                type of the argument  */

        Function<Integer, String> function1 = Object::toString;
        System.out.println(function1.apply(2));

        Function<String, Integer> function2 = Integer::parseInt;
        System.out.println(function2.apply("1"));
    }
}
