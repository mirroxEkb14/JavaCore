package Dates.Datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {

    // immutable class

    public static void main(String[] args) {
        java.time.LocalDateTime ldt = java.time.LocalDateTime.now();
        java.time.LocalDateTime.now(ZoneId.of("America/Chicago")); // with timezone

        ldt.toLocalDate(); // 2020-12-29
        ldt.toLocalTime(); // 19:34:04.288425400

        // from String to LocalDateTime
        String strDateTime = "29-12-2020T19:44";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        java.time.LocalDateTime strLdt = java.time.LocalDateTime.parse(strDateTime, dtf); // 2020-12-29T19:44

        // from dateTime to dateTime with timezone
        Instant instant = strLdt.toInstant(ZoneId.of("America/Chicago").getRules().getOffset(strLdt)); // 2020-12-30T01:44:00Z

        // how to change the current date
        java.time.LocalDateTime curLdt = java.time.LocalDateTime.now();

        java.time.LocalDateTime changedLdt = curLdt.with(temporal -> temporal.plus(3, ChronoUnit.DAYS)); // + 2 days
        System.out.println(changedLdt);
    }
}
