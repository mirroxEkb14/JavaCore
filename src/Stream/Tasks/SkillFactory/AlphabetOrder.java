package Stream.Tasks.SkillFactory;

import java.util.*;

/**
 * в списке отобрать первые 2 строки в
 * алфавитном порядке
 */

public class AlphabetOrder {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Toby", "Anna", "Leroy", "Alex");

        withoutStream(names);
        withStream(names);
    }

    public static void withStream(List<String> names) {
        names.stream()
                .limit(2)
                .sorted()
                .forEach(System.out::println);
    }

    public static void withoutStream(List<String> names) {
        List<String> filtered = new ArrayList<>();
        for (String name: names) {
            if (name.length() == 4 && filtered.size() < 2) {
                filtered.add(name);
            }
        }

        filtered.sort(Comparator.naturalOrder());
        for (String name: filtered) {
            System.out.println(name);
        }
    }
}
