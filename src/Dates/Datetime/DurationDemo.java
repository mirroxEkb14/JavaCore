package Dates.Datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationDemo {

    // immutable class

    public static void main(String[] args) {
        /*  Duration -> hours, minutes, seconds  */

        // lets calculate seconds from "dateOne" midnight to "dateTwo" midnight
        LocalDate curLd = LocalDate.now();
        LocalDate prevLd = LocalDate.of(2020, 12, 28);

        // parse to "LocalDateTime"
//        LocalDateTime ldt = LocalDateTime.of(curLd, LocalTime.MIDNIGHT);
        LocalDateTime curLdt = curLd.atStartOfDay();
        LocalDateTime prevLdt = prevLd.atStartOfDay();

        java.time.Duration duration = java.time.Duration.between(prevLdt, curLdt);
        duration.getSeconds(); // seconds

        long minutes = ChronoUnit.MINUTES.between(prevLdt, curLdt); // minutes
    }
}
