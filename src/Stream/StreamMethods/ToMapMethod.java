package Stream.StreamMethods;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToMapMethod {

    /**
     * Собирает элементы в Map. Каждый элемент преобразовывается в ключ и в значение,
     * основываясь на результате функций keyMapper и valueMapper соответственно.
     * Если нужно вернуть тот же элемент, что и пришел, то можно передать Function.identity().
     */

    public static void main(String[] args) {
        Map<Integer, Integer> map1 = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                        Function.identity(),
                        Function.identity()
                ));
        // {1=1, 2=2, 3=3, 4=4, 5=5}

        /**
         * Аналогичен первой версии метода, только в случае,
         * когда встречается два одинаковых ключа, позволяет объединить значения.
         */
        Map<Integer, String> map4 = Stream.of(50, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                        i -> i % 5,
                        i -> String.format("<%d>", i),
                        (a, b) -> String.join(", ", a, b)
                ));
        // {0="<50>, <55>, <20>", 2="<52>", 4="<64>, <19>"}

        /**
         * Всё то же, только позволяет указывать, какой именно класс Map использовать.
         */
        Map<Integer, String> map5 = Stream.of(50, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                        i -> i % 5,
                        i -> String.format("<%d>", i),
                        (a, b) -> String.join(", ", a, b),
                        LinkedHashMap::new
                ));
        // {0=<50>, <55>, <20>, 4=<69>, <19>, 2=<52>}
    }
}
