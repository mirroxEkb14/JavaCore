package Dates.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNextEvent {

    public static void main(String[] args) throws ParseException {
        String eventDate = "23.03.2021";
        System.out.println(getEventDate(eventDate));

    }

    public static String getEventDate(String input) throws ParseException {
        long curDate = new Date().getTime(); // current date

        long eventDate = new SimpleDateFormat("dd.MM.yyyy").parse(input).getTime();

        if (eventDate > curDate) {
            return "Days left: " + Math.round((eventDate - curDate) / 86400000);
        }
        return "Your date is greater than the current one";
    }
}
