package JavaCollections.QueueGenerics;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class GenericsCollect {
    public static void main(String[] args) {
        /* we can put any type of data in 'queue' but if we want to assign(присвоить)
            selected element to some variable, we need 'casting'(преобразование)
            <> - 'diamond operator' (параметризованный тип - generic type) */

        Queue queue = new LinkedList<>();
        queue.add("string"); // type: Object
        queue.add(1);
        queue.add(new Date());

        // String = (String) Object (downcast)
        String element = (String) queue.poll();
    }
}
