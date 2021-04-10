package Exceptions.ModuleTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    /**
     * Написать программу, которая будет считывать целые числа с клавиатуры
     * до тех пор, пока не будет введена строка. Когда будет введена строка,
     * программа должна поймать исключение и вывести все введенные до этого
     * числа на экран в том же порядке.
     * @param args
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>();

        try {
            while (true) {
                integers.add(scanner.nextInt());
            }
        } catch (Exception e) {
            for (int i = 0; i < integers.size(); i++) {
                System.out.print(integers.get(i) + " ");
            }
        }
    }
}
