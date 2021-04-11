package JavaTasks.Itnanru.Basis;

public class PrimeNumbers {

    /**
     * Напишите программу, которая выводит на
     * консоль простые числа в промежутке от [2, 100].
     * Используйте для решения этой задачи оператор
     * "%" (остаток от деления) и циклы.
     * @param args
     */

    public static void main(String[] args) {

        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) System.out.print(i + " ");
        }
    }
}
