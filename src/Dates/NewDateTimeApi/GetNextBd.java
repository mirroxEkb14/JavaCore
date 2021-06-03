package Dates.NewDateTimeApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetNextBd {

    public static void main(String[] args) {
        /*  next bd  */
        LocalDate curDate = LocalDate.now();

        String strBdDate = "30.08.2002"; // bd date in string
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // format of string
        LocalDate bdDate = LocalDate.parse(strBdDate, dtf); // parse to "LocalDate"

        bdDate = bdDate.plusYears(curDate.getYear() - bdDate.getYear()); // bd year = current year

        if (bdDate.isBefore(curDate)) { // if next bd is next year
            bdDate = bdDate.plusYears(1); // now bd year is next year
            System.out.printf("Days left: %d", (365 - curDate.getDayOfYear()) + bdDate.getDayOfYear());

        } else { // if next bd is this year
            System.out.printf("Days left: %d", bdDate.getDayOfYear() - curDate.getDayOfYear());
        }
    }
}
