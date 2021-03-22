package Stream.StreamMethods;

import java.util.stream.Stream;

public class TakeWhileMethod {

    /**
     * Возвращает элементы до тех пор, пока они удовлетворяют условию,
     * то есть функция-предикат возвращает true. Это как limit,
     * только не с числом, а с условием.
     * @param args
     */

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 2, 5)
                .takeWhile(x -> x < 3)
                .forEach(System.out::println);
        // 1, 2
    }
}
