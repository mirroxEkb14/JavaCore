package Stream.StreamMethods;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DropWhileMethod {

    /**
     * Пропускает элементы до тех пор, пока они удовлетворяют условию,
     * затем возвращает оставшуюся часть стрима. Если предикат вернул
     * для первого элемента false, то ни единого элемента не будет пропущено.
     * Оператор подобен skip, только работает по условию.
     * @param args
     */

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 2, 5)
                .dropWhile(x -> x >= 3)
                .forEach(System.out::println);
        // 1, 2, 3, 4, 2, 5

        Stream.of(1, 2, 3, 4, 2, 5)
                .dropWhile(x -> x < 3)
                .forEach(System.out::println);
        // 3, 4, 2, 5
    }
}
