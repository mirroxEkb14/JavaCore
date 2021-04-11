package JavaTasks.Itnanru.Basis;

public class Vector {

    /**
     * Создайте класс, который описывает вектор (в трёхмерном пространстве).
     *
     * У него должны быть:
     *
     * конструктор с параметрами в виде списка координат x, y, z
     * метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt():
     * sqrt{x^2 + y^2 + z^2}$
     *
     * метод, вычисляющий скалярное произведение:
     * x_1x_2 + y_1y_2 + z_1z_2
     *
     * метод, вычисляющий векторное произведение с другим вектором:
     * (y_1z_2 - z_1y_2, z_1x_2 - x_1z_2, x_1y_2 - y_1x_2)
     *
     * метод, вычисляющий угол между векторами (или косинус угла):
     * косинус угла между векторами равен скалярному произведению векторов,
     * деленному на произведение модулей (длин) векторов:
     * (a,b) \ |a| * |b|
     *
     * методы для суммы и разности:
     * (x_1 + x_2, y_1 + y_2, z_1 + z_2)
     *
     * (x_1 - x_2, y_1 - y_2, z_1 - z_2)
     *
     *
     * статический метод, который принимает целое число N,
     * и возвращает массив случайных векторов размером N.
     *
     * Если метод возвращает вектор, то он должен возвращать новый объект,
     * а не менять базовый. То есть, нужно реализовать шаблон "Неизменяемый объект"
     */

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)); // sqrt(x * x + y * y + z * z)
    }

    public double scalarProduct(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public Vector crossProduct(Vector vector) {
        return new Vector(
                y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x
        );
    }

    public double cos(Vector vector) {
        return scalarProduct(vector) / (length() * vector.length());
    }

    public Vector add(Vector vector) {
        return new Vector(
                x + vector.x,
                y + vector.y,
                z + vector.z
        );
    }

    public Vector subtract(Vector vector) {
        return new Vector(
                x - vector.x,
                y - vector.y,
                z - vector.z
        );
    }

    public static Vector[] generate(int n) {
        Vector[] vectors = new Vector[n];

        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
