package Dates.Datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDemo {

    // immutable class

    public static void main(String[] args) {
        /*  set time  */
        java.time.LocalDate localDate = java.time.LocalDate.now(); // current date (2020-12-28)
        java.time.LocalDate givenDate = java.time.LocalDate.of(2020, 12, 28); // given date (2020-12-28)

        DateTimeFormatter dtfExample = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        java.time.LocalDate parsedDate = java.time.LocalDate.parse("28/12/2020", dtfExample); // 2020-12-28


        // plus or minus days/weeks/months/years
        givenDate.minusDays(5);
        givenDate.plusWeeks(2);


        // compare dates
        localDate.compareTo(givenDate);
        localDate.isAfter(givenDate);
        localDate.isBefore(givenDate);
        localDate.equals(givenDate);


        // get values
        localDate.getDayOfWeek(); // MONDAY
        localDate.getMonthValue(); // 12
        localDate.getMonth(); // DECEMBER


        /*  format time  */
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dtf.format(localDate); // 28/12/2020
    }
}
