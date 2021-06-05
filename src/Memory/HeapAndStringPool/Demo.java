package Memory.HeapAndStringPool;

public class Demo {

    public static void main(String[] args) {

        /* When we have the same value (str3), Java does not make space
           for this variable, it creates a new link to already existed memory area(String pool)
           ("wasd" already exists in String pool(str1), so now 'str3' links to this existed
           "wasd", new memory is not allocated)

           When we create a string with "new", it creates in heap (allocates new memory space) */
        String str1 = "wasd"; // created in pool(memory was allocated)
        String str2 = new String("wasd"); // created in heap(memory was allocated)
        String str3 = "wasd"; // linked to 'str1'(memory was not allocated)

        // '==' operator compares objects by location in memory
        // 'equals()' method compares by string content("wasd")
        System.out.println(str1 == str2); // false
        System.out.println(str1.equals(str2)); // true
        System.out.println(str1 == str3); // true

        // str2 were in heap, now it`s in String pool like 'str1'
        str2 = str2.intern();
        System.out.println(str1 == str2); // true

        /* when we need to loop through an array, the use of 'String' is irrational(strings are immutable)
            because if we change a string during the iteration, Java makes new space
            for each edited string, memory leak occurs, in this case we need 'StringBuilder' class,
            it edits the current string, does not create a new one, memory is saved */
        StringBuilder editString = new StringBuilder("a string to edit");
//        for (int i = editString.length() - 1; i < editString.length(); i++) {
//            editString.append("1");
//        }
//        System.out.println(editString);
    }
}
