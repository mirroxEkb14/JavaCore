package Memory.HeapAndStack;

public class Memory {

    /*
        1. Starting the program, all the classes are loaded into heap.
        Then, 'main()' method finds 'string1' and Java Runtime creates
        a block in stack memory that 'main()' method will use
        (in that block will be stored local variables of 'main()' method).

        2. On 'string2' an int variable is created that is stored
        in stack memory

        3. Then, on 'string3' we create a new object that appears in heap,
        while stack memory contains a link to it. The same with 'memory'
        variable on 'string4'

        4. On 'string5' we call 'exMethod()' and a new block in stack memory
        is created(this block will be used by 'exMethod()', local variables of
        'exMethod' are stored there). On 'string6' creates a new link to
        object in 'string3'

        5. On 'string7' the string goes to String Pool memory in heap. Creates
        a link to this string in stack memory(in block of 'exMethod')

        6. On 'string8' method 'exMethod' ends, the block of this method in
        stack memory is cleaned

        7. On 'string9' method 'main()' ends, the block of this method in
        stack memory will be destroyed. Also, the program ends on this string,
        what means that Java Runtime frees all left memory and ends the program


        Difference.
        - Stack memory is used only by one thread, while heap memory can be used
        by any part of application
        - When a new object is created, it is always stored in heap(or String Pool),
        and stack memory contains a reference to it. Stack memory contains only local
        variables of primitive type and links to objects in heap
        - Memory management in stack implements by LIFO scheme
        - Heap memory lives till the program ends, stack memory exists only for a while
        - Size of heap memory is much more than size of stack memory, so stack memory
        works faster
     */

    public static void main(String[] args) { // строка 1
        int i=1; // строка 2
        Object object = new Object(); // строка 3
        Memory memory = new Memory(); // строка 4
        memory.exMethod(object); // строка 5
    } // строка 9

    private void exMethod(Object param) { // строка 6
        String string = param.toString(); // строка 7
        System.out.println(string );
    } // строка 8
}
