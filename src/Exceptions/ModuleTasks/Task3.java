package Exceptions.ModuleTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}

public class Task3 {

    /**
     * Дан код с использованием try-catch,
     * перепишите данный код с использованием try-with-resources.
     * @param args
     */

    public static void main(String[] args) {

    }

    public String input() throws MyException, IOException {
        String s = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        if (s.equals("")) {
            throw new MyException("String can not be empty!");
        }

        return s;
    }
}
