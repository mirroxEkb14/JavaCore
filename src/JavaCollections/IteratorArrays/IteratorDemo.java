package JavaCollections.IteratorArrays;

public class IteratorDemo {

    public static void main(String[] args) {
        List<String> list = new List<>(3);
        list.add("String1");
        list.add("String2");
        list.add("String3");

        list.forEach(System.out::println);
        list.iterator().forEachRemaining(System.out::println);
    }
}
