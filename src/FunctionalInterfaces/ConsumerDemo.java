package FunctionalInterfaces;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        /*  takes 1 argument and returns nothing  */

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("test string");

        Consumer<Integer> consumer2 = x -> System.out.println("test " + x);
        consumer2.accept(1);
    }
}
