package Threads.ChickenEggProgram;

public class Main {

    public static void main(String[] args) {
        Thread chicken = new ChickenEgg("chicken");
        Thread egg = new ChickenEgg("egg");

        System.out.println("Start the dispute: who appeared first?");

        chicken.start();
        egg.start();

        while (egg.isAlive() || chicken.isAlive()) {
            try {
                Thread.sleep(100);
                System.out.println("Chicken");
            } catch ( InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (egg.isAlive()) {
            try {
                egg.interrupt();
                egg.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("An egg appeared first!");

        } else {
            try {
                chicken.interrupt();
                chicken.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A chicken appeared first!");
        }

        System.out.println("The dispute is over");
    }
}
