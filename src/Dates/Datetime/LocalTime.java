package Dates.Datetime;

import java.time.*;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Date;

public class LocalTime {

    // immutable class

    public static void main(String[] args) {

        /**
         * Напишите метод, который будет принимать 2 объекта: 1 типа LocalTime и 2 типа Duration,
         * и будет возвращать true, если переданное время + промежуток больше текущего времени.
         */

        System.out.println(timeDifference(java.time.LocalTime.of(21, 44), java.time.Duration.of(0, ChronoUnit.MINUTES)));

        /**
         * Создайте метод, который принимает в качестве аргумента объект java.util.Date и
         * возвращает объект LocalTime, содержащий время переданного объекта в вашем часовом поясе.
         */

        Date date = new Date(); // Tue Dec 29 22:02:54 ALMT 2020
        System.out.println(toLocalTime(date)); // 22:02:54.457
    }

    public static java.time.LocalTime toLocalTime(Date date) {
        Instant instant = date.toInstant(); // 2020-12-29T16:02:54.457Z
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        return zdt.toLocalTime();
    }

    public static boolean timeDifference(java.time.LocalTime userTime, java.time.Duration duration) {
        return userTime.plus(duration).isAfter(java.time.LocalTime.now()) ;
    }
}
