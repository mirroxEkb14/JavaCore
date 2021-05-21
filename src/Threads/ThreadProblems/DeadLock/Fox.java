package Threads.ThreadProblems.DeadLock;

public class Fox {

    /**
     * This program will be working till you kill it
     * because the threads(thread1, thread2) are
     * waiting for the objects that will not be free.
     * (thread1 took 'food' object, thread2 - 'water' object)
     */

    private static void eatAndDrink(Food food, Water water) {

        /**
         * The problem is in the code below. One thread
         * blocks two objects at the same time. So, when
         * 'thread1' blocks the 'food' object, maybe, 'thread2'
         * has already blocked the 'water' object, after that
         * 'thread1' wants to block the 'water' object but
         * it`s already blocked. 'thread2' also wants to block
         * the 'food' object but it`s already blocked. In the end,
         * we have two threads that are waiting for the objects which
         * are blocked and the program will be working till we kill it
         */

        synchronized (food) {
            System.out.println("God food!");
            move();

            synchronized (water) {
                System.out.println("Got water!");
            }
        }
    }

    private static void drinkAndEat(Food food, Water water) {
        synchronized (water) {
            System.out.println("Got water!");
            move();

            synchronized (food) {
                System.out.println("Got food!");
            }
        }
    }

    private static void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Fox fox1 = new Fox();
        Fox fox2 = new Fox();
        Food food = new Food();
        Water water = new Water();

        Thread thread1 = new Thread() {
            public void run() {
                fox1.eatAndDrink(food, water);
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                fox2.drinkAndEat(food, water);
            }
        };

        thread1.start();
        thread2.start();
    }
}
