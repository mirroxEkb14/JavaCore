package Stream.StreamMethods;

import java.util.HashMap;
import java.util.Map;

public class ForeachMethod {

    /*
     * Consumer<T>	-> 1 parameter T
     *                 returns - void
     *                 abstract method - accept
     *                 принимает 1 параметр и ничего не возвращает («потребитель»)
     */

    public static void main(String[] args) {
        Map<String, Double> movieRating = new HashMap<>();

        movieRating.put("Forrest Gump", 8.8);
        movieRating.put("The Matrix", 8.7);
        movieRating.put("The Hunt", 8.3);

        movieRating.entrySet().stream()
                .forEach(n -> {
                    if (n.getValue() > 8.3) {
                        System.out.println("The movie -> " + n.getKey() + ", " + n.getValue());
                    }
                });

        // the same expression but with 'filter' instead of 'if' block
        movieRating.entrySet().stream()
                .filter(n -> n.getValue() < 8.7)
                .forEach(n -> System.out.println("The movie -> " + n.getKey() + ", " + n.getValue()));
    }
}
