package JavaTasks.Module3Tasks;

public class Task3D {

    /**
     * Прошло соревнование среди 5 участников: Саша, Игорь, Миша, Коля и Владимир,
     * по 5 различным дисциплинам. Организаторами был создан двухмерный массив:
     * каждая i-ая строка — это количество полученных баллов i-го игрока.
     *
     * Задание: вывести одномерный массив в виде "<Имя игрока>  <сумма баллов>".
     */

    public static void main(String[] args) {
        String[] names = {"Sasha", "Igor", "Misha", "Kolya", "Vladimir"};
        int[][] points = {
                {4, 3, 2, 5, 1},
                {3, 4, 4, 6, 2},
                {2, 5, 4, 3, 2},
                {8, 4, 2, 0, 4},
                {4, 4, 3, 2, 9},
        };

        int[] sumOfPoints = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                sumOfPoints[i] += points[i][j];
            }

            System.out.printf("Name: %s, points: %s\n", names[i], sumOfPoints[i]);
        }
    }
}
