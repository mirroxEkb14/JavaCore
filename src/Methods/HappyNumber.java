package Methods;

public class HappyNumber {

    /**
     * Счастливое число определено следующим процессом.
     * Начиная с некоторого положительного целого числа,
     * замените число суммой квадратов его цифр и повторяйте
     * процесс до тех пор, пока число не будет равным одному
     * (на чем все и остановится) или оно будет циклиться
     * бесконечно. Если цикл конечен, то изначальное число
     * называется счастливым.
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(isHappyNumber(2));
    }

    public static boolean isHappyNumber(int number) {
        String[] stringNumbers  = String.valueOf(number).split("");

        int result = 0;
        while (result != 1) {
            for (String stringNumber : stringNumbers) {
                result += Math.pow(Integer.parseInt(stringNumber), 2);
            }
            stringNumbers = String.valueOf(result).split("");
            if (result != 1) result = 0;
        }
        return true;
    }
}
