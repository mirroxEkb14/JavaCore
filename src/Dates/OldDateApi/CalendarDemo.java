package Dates.OldDateApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime(); // Mon Dec 28 00:24:16 ALMT 2020
        calendar.add(Calendar.WEEK_OF_MONTH, -1); // -one week

        /*  parse Date to Calendar  */

        Date currentDate = new Date();
        calendar.setTime(currentDate);
        calendar.getTime(); // Mon Dec 28 00:25:57 ALMT 2020


        /*  DateFormat
          DateFormat.SHORT -> 28.12.2020
          DateFormat.DEFAULT -> 28 дек. 2020 г.  */

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        dateFormat.format(calendar.getTime());


        /*  SimpleDateFormat  */
        SimpleDateFormat sdf = new SimpleDateFormat(); // "dd/MM/yyyy"
        System.out.println(sdf.format(calendar.getTime())); // 28.12.2020, 00:33


        /*  get date units  */
        System.out.println(calendar.get(Calendar.MONTH)); // and etc.
    }
}
