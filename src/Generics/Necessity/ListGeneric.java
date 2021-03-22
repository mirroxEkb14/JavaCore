package Generics.Necessity;

public class ListGeneric<T> {
    private final T[] objects; // out list
    private int size;

    public ListGeneric(int initialSize) {
        this.objects = (T[]) new Object[initialSize];
    }

    public void add(T element) {
        objects[size++] = element;
    }

    public T get(int index) {
        return objects[index];
    }

    public int getSize() {
        return size;
    }
}
