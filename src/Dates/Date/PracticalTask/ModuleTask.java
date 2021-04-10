package Dates.Date.PracticalTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ModuleTask {

    public static void main(String[] args) throws ParseException {

        // https://docs.google.com/document/d/1NhvmN_7vFiCcS4WAZqmoZdDxHEjwn-B4HQMS2pgX3d8/edit?usp=sharing

        String inputDate = "01.01.2022"; // New Year 2022!!!

        Calendar currentDate = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar newYearDate = Calendar.getInstance();
        newYearDate.setTime(sdf.parse(inputDate));

        System.out.println(newYearDate.getTime());

        System.out.println(currentDate.getTime());

        newYearDate.getTime();

        newYearDate.getTime().getTime();

        System.out.println("Days left before New Year 2022: " +
                ((newYearDate.getTime().getTime() - currentDate.getTime().getTime()) / 86400000 + 1));
    }
}
