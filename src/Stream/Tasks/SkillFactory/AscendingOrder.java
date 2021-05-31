package Stream.Tasks.SkillFactory;

import java.util.ArrayList;
import java.util.List;

public class AscendingOrder {

    /**
     * Задан лист строк, используя средства StreamAPI,
     * отсортируйте строки по возрастанию.
     */

    public static void main(String[] args) {
        List< String > list = new ArrayList< >();
        list.add("Hello");
        list.add("my");
        list.add("name");
        list.add("is");
        list.add("Annnnna");

        list.sort((s1, s2) -> s2.length() - s1.length());
        System.out.println(list); // [Annnnna, Hello, name, my, is]
    }
}
