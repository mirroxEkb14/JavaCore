package Stream.StreamMethods;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectMethod {

    /**
     * There are 3 methods:
     *      Collectors.toList()
     *      Collectors.toSet()
     *      Collectors.toMap()
     *
     * @param args
     */

    public static void main(String[] args) {
        List<String> phones = List.of("Iphone", "Samsung", "Xiaomi", "Xiaomi");

        Set<String> phonesSet = phones.stream()
                .filter(n -> n.startsWith("X") || n.startsWith("S"))
                .collect(Collectors.toSet());

        System.out.println(phonesSet);
    }
}
