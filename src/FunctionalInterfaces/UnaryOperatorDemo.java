package FunctionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {

    public static void main(String[] args) {
        /*  takes 1 argument and return the argument
                of the same type  */

        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println(unaryOperator.apply(5));
    }
}
