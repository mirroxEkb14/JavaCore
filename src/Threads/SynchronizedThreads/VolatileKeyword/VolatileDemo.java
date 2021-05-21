package Threads.SynchronizedThreads.VolatileKeyword;

import java.util.Scanner;

public class VolatileDemo {

    public static void main(String[] args) {

        /* Here every 100ms 'hello' is printed in the console
           till user enters something, then 'while' loop ends
           and the program is finished. But there is a chance
           that the program will be running till we kill it

           Every processor core has its cache memory that
           contains some data the processor must process.
           Imagine that 'main' and 'MyThread' threads will
           run on different cores. Then, on the core where
           'MyThread' thread is running, the value of 'running'
           saves in cache memory like 'true', after that in
           'main' thread the value of 'running' changes to
           'false', but 'MyThread' thread takes 'running' value
           from core cache where its value is 'true'. As a result,
           we get a program that will be running till we kill it

           'volatile' keyword gives the guarantee that 'running'
           value will not be written in cache memory but in main
           memory, so such a situation will not happen

         */

        MyThread thread1 = new MyThread();
        thread1.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        thread1.shutDown();
    }
}
