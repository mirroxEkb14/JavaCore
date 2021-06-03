package Dates.OldDateApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetNextBD {
    public static void main(String[] args) throws ParseException {
        /*  calculate time from A date to B date  */

        Date dateStart = new SimpleDateFormat("dd.MM.yyyy").parse("30.08.2002");
        Date dateEnd = new SimpleDateFormat("dd.MM.yyyy").parse("28.12.2020");

        // 86400000 milliseconds in a day
        System.out.println("Difference in days: " + Math.round((dateEnd.getTime() - dateStart.getTime()) / (double) 86400000));


        /*  calculate next bd date  */

        Date currentDate = new Date(); // current date
        Date bdDate = new SimpleDateFormat("dd/MM/yyyy").parse("31/08/2002"); // user`s bd

        Calendar currentCalendar = Calendar.getInstance(); // current date in 'Calendar'
        currentCalendar.setTime(currentDate);

        Calendar bdCalendar = Calendar.getInstance(); // bd date in 'Calendar'
        bdCalendar.setTime(bdDate);

        if (bdDate.before(currentDate)) { // user`s birth date cannot be more than the current one
            bdCalendar.set(Calendar.YEAR, currentCalendar.get(Calendar.YEAR));

            if (bdCalendar.before(currentCalendar)) { // if user`s bd is next year
                bdCalendar.set(Calendar.YEAR, currentCalendar.get(Calendar.YEAR) + 1);

                System.out.printf("Days left: %d", (365 - currentCalendar.get(Calendar.DAY_OF_YEAR) + bdCalendar.get(Calendar.DAY_OF_YEAR)));

            } else { // if user`s bd is this year
                System.out.printf("Days left: %d", bdCalendar.get(Calendar.DAY_OF_YEAR) - currentCalendar.get(Calendar.DAY_OF_YEAR));
            }

        } else {
            System.out.println("Your birth date cannot be more than the current one");
        }
    }
}
