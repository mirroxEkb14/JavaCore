package JavaCollections.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetCollections {
    public static void main(String[] args) {
        /*  'Set' contains unique objects, can contain 'null'  */

        Set<String> hashSet = new HashSet<>(); // not in order
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");

        Set<String> linkedHashSet = new LinkedHashSet<>(); // in order (needs more memory)
        linkedHashSet.add("one");
        linkedHashSet.add("two");
        linkedHashSet.add("three");

        Set<String> treeSet = new TreeSet<>(); // sort in alphabetical order (a, b, ...; 1, 2, ...)
        treeSet.add("c");
        treeSet.add("b");
        treeSet.add("a");

        /* how to print */
        for (String s: hashSet) {
            System.out.println(s);
        }
    }
}
