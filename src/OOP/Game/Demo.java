package OOP.Game;

public class Demo {

    public static void main(String[] args) {
        Zombie zombie = new Zombie(100, 10);
        GiantSnake snake = new GiantSnake(100, 20);

        Battle battle = new Battle();
        battle.add(zombie);
        battle.add(snake);

        battle.showParty();

        zombie.attack(snake);
        System.out.println("Snake`s HP after 1 zombie`s attack: " + snake.getHp());

        snake.attack(zombie);
        System.out.println("Zombie`s HP after 1 snake`s attack: " + zombie.getHp());

        zombie.attack(snake);
        zombie.attack(snake);
        zombie.attack(snake);
        zombie.attack(snake);
        System.out.println("Snake`s HP after 5 zombie`s attack: " + snake.getHp());

        snake.attack(zombie);
        snake.attack(zombie);
        snake.attack(zombie);
        System.out.println("Zombie`s HP after 4 snake`s attack: " + zombie.getHp());

        snake.attack(zombie);
        System.out.println("Zombie`s HP after 5 snake`s attack: " + zombie.getHp()); // 0

        snake.attack(zombie);
    }
}
