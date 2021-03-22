package Dates.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DatesOld {
    public static void main(String[] args) {

    }
}

class setDate {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(dateFormat.format(calendar.getTime()));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMMM/yy HH:mm:ss");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}

class getDate {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date + "\n");

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        // edit the current date
        Date currentDate = new Date();

        SimpleDateFormat format = new SimpleDateFormat("E dd.MM.yyyy X", Locale.US);
        String formatted = format.format(currentDate);
        System.out.println(formatted);

        Date parsedDate = format.parse(formatted);
        System.out.println(parsedDate);

        // set hour/day/year etc.
        calendar.add(Calendar.DAY_OF_MONTH, 6);
    }
}

class getNextEvent1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date in the following format: day.month.year"); // ask the date
        getNextEvent(scanner.nextLine()); // all the logic
    }

    public static void getNextEvent(String inputDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.US); // template

            Date currentDate = new Date(); // the current date in milliseconds
            Date userDate = sdf.parse(inputDate); // user`s date in milliseconds

            if (userDate.after(currentDate)) { // if user`s date is bigger than today
                System.out.printf("The difference between today(%s) and %s is: %d days\n", sdf.format(currentDate.getTime()), inputDate,
                        (userDate.getTime() - currentDate.getTime()) / 86400000);
            } else { // if not
                System.out.println("Your date is earlier than today!");
            }
        } catch (ParseException e) { // if user`s date is not in the format 'dd.MM.yyyy'
            System.out.println("You entered the wrong date: " + inputDate);
        }
    }
}

class DateProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like?\n1.Next event\n2.When`s my next birthday?\n3.Hmm... when`s the new year?\n");
        requestHandler(scanner.nextLine()); // this method handles user request
    }

    // checking if the user entered "q"
    public static boolean isQ(String input) {
        boolean isQ = false;

        if (input.equals("q") || input.equals("Q")) {
            System.out.println("\nbye-bye");
            isQ = true;
        }
        return isQ;
    }

    public static void requestHandler(String request) {
        Scanner scanner = new Scanner(System.in);
        String input; // what the user enters

        if (!isQ(request)) { // 'q' verification
            if (request.equals("1") || request.equals("1.") || request.equals("Next event")  || request.equals("next event")) {
                System.out.println("\nEnter a date in the following format: day.month.year");
                if (!isQ((input = scanner.nextLine()))) { // 'q' verification
                    getNextEvent(input);
                }
            } else if (request.equals("2") || request.equals("2.") || request.equals("When`s my next birthday?")  ||
                    request.equals("when`s my next birthday?") || request.equals("When`s my next birthday") || request.equals("when`s my next birthday") ||
                    request.equals("my next birthday") || request.equals("My next birthday") || request.equals("My birthday") || request.equals("my birthday")) {
                System.out.println("\nWhen were you born? (day.month.year)");
                if (!isQ((input = scanner.nextLine()))) { // 'q' verification
                    getBirthday(input);
                }
            } else if (request.equals("3") || request.equals("3.") || request.equals("When`s the new year?") || request.equals("when`s the new year?") ||
                    request.equals("New year") || request.equals("new year")) {
                getNewYear();
            }
        }
    }

    public static void getNextEvent(String inputDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); // template

            Date currentDate = new Date(); // the current date in milliseconds
            Date userDate = sdf.parse(inputDate); // user date in milliseconds

            if (userDate.after(currentDate)) { // if user date is bigger
                System.out.printf("\nFrom %s to %s - %d days", sdf.format(currentDate.getTime()), inputDate, (userDate.getTime() - currentDate.getTime()) / 86400000);
            } else { // if not
                System.out.printf("\nYour date is earlier than today!\ntoday - %s\nyour date - %s", sdf.format(currentDate.getTime()), inputDate);
            }
        } catch (ParseException e) { // if the user entered a date not in the format: 'dd.MM.yyyy'
            System.out.println("\nYou entered the wrong date: " + inputDate);
        }
    }

    public static void getBirthday(String inputDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); // template

            Date currentDate = new Date(); // the current date in milliseconds
            Date userDate = sdf.parse(inputDate); // user date in milliseconds

            if (currentDate.after(userDate)) { // if the current date is bigger
                Calendar calendar = Calendar.getInstance(); // get the current date to get the current year later
                calendar.setTime(new Date());

                String[] dividedDate = inputDate.split("\\."); // divide the date into three parts (day, month, year)
                // replace user`s birth year with the current year
                userDate = sdf.parse(dividedDate[0].concat(".").concat(dividedDate[1]).concat(".").concat(String.valueOf(calendar.get(Calendar.YEAR))));

                if (currentDate.after(userDate)) { // if the current date is bigger than user`s bd this year (it means the next user`s bd is next year)
                    // replace user`s birth year with the next year
                    userDate = sdf.parse(dividedDate[0].concat(".").concat(dividedDate[1]).concat(".").concat(String.valueOf(calendar.get(Calendar.YEAR) + 1)));
                    System.out.printf("\n%d days left\n", (userDate.getTime() - currentDate.getTime()) / 86400000);

                } else { // if user`s bd this year is bigger than the current date (it means the next user`s bd is this year)
                    System.out.printf("\n%d days left\n", (userDate.getTime() - currentDate.getTime()) / 86400000);
                }

            } else { // if not
                System.out.println("\nYou were born earlier than today...");
            }
        } catch (ParseException e) {
            System.out.println("\nYou entered the wrong date: " + inputDate);
        }
    }

    public static void getNewYear() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

            Calendar calendar = Calendar.getInstance(); // new year date
            calendar.setTime(new Date());
            Date newYearDate = sdf.parse("31.12." + calendar.get(Calendar.YEAR));

            Date currentDate = new Date(); // the current date

            System.out.printf("\nThe New Year is in %d days\n", (newYearDate.getTime() - currentDate.getTime()) / 86400000);

        } catch (ParseException e) {
            System.out.println("\nNew Year ParseException: " + e);
        }
    }
}