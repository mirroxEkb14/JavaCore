package Optionals;

import java.util.Optional;

public class Demo {

    public static void main(String[] args) {
        Optional<Double> averageValue = average(95, 100);

        averageValue.ifPresent(System.out::println);

        if (averageValue.isPresent()) System.out.println(averageValue.get());

        System.out.println(averageValue.orElse(Double.NaN));
        System.out.println(averageValue.orElseGet(Math::random));
        System.out.println(averageValue.orElseThrow(IllegalStateException::new));
    }

    public static Optional<Double> average(int... scores) {
        /*  This method returns 'Optional' that means it can return 'null',
                so we do not get 'NullPointerException' but we can handle
                the situation when we get 'null' without getting an exception  */

        if (scores.length == 0) {
            return Optional.empty();

        } else {
            int sum = 0;
            for (Integer score: scores) {
                sum += score;
            }
            return Optional.of((double) sum / scores.length);
        }
    }
}