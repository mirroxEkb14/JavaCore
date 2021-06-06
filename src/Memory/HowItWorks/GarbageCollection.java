package Memory.HowItWorks;

public class GarbageCollection {

    /*
        GC - is a mechanism of freeing up RAM, previously allocated to objects.
        In C, C++ languages you have to free memory by yourself, using 'delete()'
        method, while in Java this process is automatic. It is a separate process,
        independent of the developer. When garbage collection is started, JVM
        pauses the application, deleting garbage, these pauses are usually invisible.
        There is a method 'System.gc()' that asks JVM to start garbage collection
        (JVM just checks, it may not start GC)

        CG has two threads:
            Search thread - finds garbage, runs in parallel with the main thread,
            a signal from this thread can cause GC thread to start
            GC thread - deletes garbage, calls 'StopTheWorld'(stopping the application
            to collect garbage)

        Heap is divided into two spaces: Young Generation, Old Generation.
        Objects in Young Generation are often checked because they often appear and
        become useless quickly.
        Objects in Old Generation are checked rarely.
        Young Generation is also divided into two parts:
            Eden Space - contains created objects
            Survivor Space - contains objects that survived after GC(two spaces: S0, S1)

        The work algorithm can be described in the following way:
            1. All the objects appear in Eden
            2. If Eden has no space, GC starts. All the left objects are copied in S0.
                Eden clears up
            3. If there is no enough space in S0, GC starts. All the left objects go to S1.
                S0 clears up
            4. If the objects in Survivor Space went through the previous GC,
                they go to Old Generation
            5. If there is no enough space in Old Generation, GC starts.
                The objects are deleted
            6. If it is impossible to place objects in Old Generation, an exception occurs
                (java.lang.OutOfMemoryError)

        For some garbage collectors 'OutOfMemoryError' can appear if garbage collection
        takes most of application running time. Such a situation is called 'gc overlimit'
        and occurs when garbage collection takes more than 98% of time and
        frees less than 2% of heap memory

        Collectors:
            Scavenge/Serial - outdated, takes a lot of time
            Concurrent Mark-Sweep(CMS) - minimize pauses with Old Generation
            Garbage First(G1) - good for large amounts of memory with
                small objects, takes lots of resources
            Parallel - minimize pauses, takes a lot of resources

     */

    public static void main(String[] args) {
        System.gc();
    }
}
