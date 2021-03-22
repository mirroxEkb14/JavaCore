package StringBuilder;

public class StringBuilderDemo {

    public static void main(String[] args) {
        // if we use 'String' class

        long start = System.currentTimeMillis();

        String string = "";
        for (int i = 0; i < 100_000; i++) {
            string += i;
        }

        long end = System.currentTimeMillis();

        System.out.printf("Time in millis: %d", end - start); // 3-5 seconds


        // if we use "StringBuilder" class

        System.out.println();

        long start2 = System.currentTimeMillis();

        StringBuilder string2 = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            string2.append(i);
        }

        long end2 = System.currentTimeMillis();

        System.out.printf("Time in millis: %d", end2 - start2); // about 4 milliseconds
    }
}
