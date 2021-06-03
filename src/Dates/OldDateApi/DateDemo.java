package Dates.OldDateApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) throws ParseException {
        /*  month index begins with 0  */

        Date currentDate = new Date();

        System.out.println(currentDate); // Mon Dec 28 00:16:41 ALMT 2020
        currentDate.getTime(); // milliseconds

        /*  parse to Date  */
        Date newDate = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2020");
        System.out.println(newDate); // Thu Dec 31 00:00:00 ALMT 2020

        /*  find the difference  */
        long milliseconds = newDate.getTime() - currentDate.getTime();
        long seconds = milliseconds / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        long weeks = days / 7;
        long months = weeks / 4;
        long years = months / 12;

//        System.out.println("milliseconds: %d\nseconds: %d\nminutes: %d\nhours: %d\ndays: %d\nweeks: %d\nmoths: %d\nyears: %d".
//                formatted(milliseconds, seconds, minutes, hours, days, weeks, months, years));

        /*  compare dates  */
        System.out.println(newDate.after(currentDate));
        System.out.println(newDate.before(currentDate));
    }
}
