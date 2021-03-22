package Dates.Datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDemo {

    public static void main(String[] args) {

        /* Period -> years, months, days  */

        // get days from date to date
        LocalDate currentLd = LocalDate.now();
        LocalDate givenLd = LocalDate.of(2021, 3, 23);

        Period period = Period.between(currentLd, givenLd);
        // full picture
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());


        // ---------------------------------- //
        long days = ChronoUnit.DAYS.between(currentLd, givenLd);
    }
}