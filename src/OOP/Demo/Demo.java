package OOP.Demo;

public class Demo {

    public static void main(String[] args) {
        Zombie zombie = new Zombie(5);
        zombie.growl();
        zombie.attack();

        // Overloading method
        zombie.growl(true);
    }
}
