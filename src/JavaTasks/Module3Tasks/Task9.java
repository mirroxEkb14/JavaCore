package JavaTasks.Module3Tasks;

public class Task9 {

    /**
     * В классе Main объявлен пустой массив strings и
     * целое число size. Вам требуется вывести
     * квадратную доску размером size x size.
     *
     * Пример при size = 4:
     * A4 B4 C4 D4
     * A3 B3 C3 D3
     * A2 B2 C2 D2
     * A1 B1 C1 D1
     */

    public static short size = 9;
    public static String[][] strings;

    public static void main(String[] args) {
        strings = new String[size][size];
        StringBuilder result = new StringBuilder();

         for (int i = 0; i < strings.length; i++) {
             for (int j = 0; j < strings[i].length; j++) {
                 strings[i][j] = "A" + j;
             }
         }

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                result.append(strings[i][j]).append(" ");
            }
            result.append("\n");
        }

        System.out.println(result.toString());
    }
}
