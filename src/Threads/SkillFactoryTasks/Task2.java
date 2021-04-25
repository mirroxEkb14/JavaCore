package Threads.SkillFactoryTasks;

public class Task2 {

    /**
     * Написать код расчета периметра равнобедренного треугольника,
     * квадрата, окружности и вывести эти значения в консоль.
     * Параметры для расчета задаются статическими переменными,
     * без ввода с клавиатуры. Для расчёта периметра фигуры необходимо
     * создать свой класс.
     * @param args
     */

    public static void main(String[] args) {
        int sideLengthTriangle = 3;
        int sideLengthSquare = 4;
        int radius = 5;
        System.out.println("Perimetr triangle = " + PerimeterTriangle(sideLengthTriangle));
        System.out.println("Perimetr square = " + PerimeterSquare(sideLengthSquare));
        System.out.println("Perimetr circle = " + PerimeterCircle(radius));
    }

    public static int PerimeterTriangle(int length) {
        int P = 3 * length;
        return P;
    }

    public static int PerimeterSquare(int length) {
        int P = 4 * length;
        return P;
    }

    public static double PerimeterCircle(int radius) {
        double PI = 3.14159;
        double P = 2 * PI * radius;
        return P;
    }
}
