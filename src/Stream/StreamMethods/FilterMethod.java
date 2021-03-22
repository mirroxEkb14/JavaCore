package Stream.StreamMethods;

import java.util.Comparator;
import java.util.List;

public class FilterMethod {

    public static void main(String[] args) {
        /*  Filters out;
            Predicate interface -> takes 1 argument and
                returns true/false  */

        List<String> strings = List.of(
                "start11end", "start22end", "start33end", "start44end", "start55end", "start66end");

        strings.stream()
                .filter(string -> string.startsWith("start"))
                .filter(string -> string.charAt(string.length() - 1) == 'd')
                .filter(string -> string.length() == 10)
                .filter(string -> string.contains("11"));


        List<Integer> integers = List.of(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integers.stream()
                .filter(integer -> integer % 2 == 0)
                .filter(integer -> integer.toString().equals("2") || integer.toString().equals("4"));
    }
}
