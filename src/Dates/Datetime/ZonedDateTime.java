package Dates.Datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ZonedDateTime {

    // immutable class

    public static void main(String[] args) {

        // date, time, UTC offset, timezone
        java.time.ZonedDateTime zdt = java.time.ZonedDateTime.now(); // 2020-12-29T19:15:39.168519800+06:00[Asia/Almaty]

        zdt.toInstant().toEpochMilli(); // milliseconds since 1970
        zdt.toInstant().getEpochSecond(); // seconds

        // get different values
        System.out.println(zdt.getDayOfWeek());
        System.out.println(zdt.getMinute());
        System.out.println(zdt.getZone()); // etc.

        // plus and minus
        zdt.plus(1, ChronoUnit.DAYS);
        zdt.minus(2, ChronoUnit.HOURS);

        zdt.plusYears(1);
        zdt.minusNanos(10); // etc.

        // truncate
        zdt.truncatedTo(ChronoUnit.DAYS); // at the beginning of the day
        zdt.truncatedTo(ChronoUnit.HOURS); // at the beginning of the hour, etc.

        // compare
//        zdt.isAfter()
//        zdt.isBefore()
//        zdt.isEqual()

        // format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        zdt.format(formatter); // 29/12/2020

        // get the current according to UTC with a shift in some time zone (Asia/Almaty)
        Instant instant = Instant.now(); // time according to UTC
        java.time.ZonedDateTime zdt2 = instant.atZone(ZoneId.of("Asia/Almaty")); // time according to time zone

        // create ZonedDateTime object in Moscow region
        java.time.ZonedDateTime zdtMoscow = java.time.ZonedDateTime.of(java.time.LocalDate.now(), java.time.LocalTime.now(), ZoneId.of("Europe/Moscow"));

        // from zone time to UTC
        java.time.ZonedDateTime zonedDateTime = java.time.ZonedDateTime.of(java.time.LocalDate.now(), java.time.LocalTime.now(), ZoneId.of("Asia/Almaty"));
        Instant instant2 = zonedDateTime.toInstant(); // Greenwich time (UTC)
    }
}
