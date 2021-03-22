package Methods;

public class Factorial {
    public static void main(String[] args) {
        int result = 1;
        int fact = 5;

        for (int i = 1; i <= fact; i++) {
            result *= i;
        }
        System.out.println(result);

        System.out.println(fac(5));
    }

    public static int fac(int n) {
        if (n == 1)
            return 1;

        return n * fac(n - 1);
    }
}
