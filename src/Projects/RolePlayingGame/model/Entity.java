package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.Fighter;
import Projects.RolePlayingGame.util.MonsterKind;
import Projects.RolePlayingGame.util.PlayerKind;

import java.util.Random;

public abstract class Entity implements Fighter {

    private String name;
    private int hp;
    private int force;
    private int agility;
    private int xp;
    private int gold;

    // constructor for player
    public Entity(String name, PlayerKind kind) {

        // if a player wants more agility
        if (kind.equals(PlayerKind.AGILITY)) {
            force = 20;
            agility = 25;

        } else { // if more force
            force = 25;
            agility = 20;
        }

        // these are default values, when a player has just started the game
        this.name = name;
        hp = 100;
        xp = 0;
        gold = 0;
    }

    // constructor for monster
    public Entity(MonsterKind kind) {

        // skeleton has more force than a goblin
        if (kind.equals(MonsterKind.SKELETON)) {
            force = 25;
            agility = 20;
            name = "Mr. Skeleton";

        } else { // but a goblin has more agility
            force = 20;
            agility = 25;
            name = "Mr. Goblin";
        }

        // monster already has hp, xp and gold
        hp = 100;
        xp = 100;
        gold = 100;
    }

    // method returns the amount of damage of the attacker
    @Override
    public int attack() {

        // if agility stat is greater than a random number, returns the attacker`s full strength
        if (this.getAgility() > getRandom()) return this.getForce();

        // 0 otherwise(the attacker missed)
        else return 0;
    }

    // returns true if the hit is succeeded,
    // false if missed
    @Override
    public boolean hit(Entity entity) {
        int attack = this.attack();

        if (attack == 0) { // if missed
            return false;

        } else { // if hit
            entity.setHp(entity.getHp() - attack);
            return true;
        }
    }

    // print all the information about the current entity
    @Override
    public void printStatistic() {
        System.out.printf("Name: %s\nCondition: %s\nForce: %d\nAgility: %d\nHP: %d\nGold: %d\n",
                this.getName(), this.isAlive()? "Alive": "Dead", this.getForce(),
                this.getAgility(), this.getHp(), this.getGold());
    }

    // false if character is dead, true if alive
    public boolean isAlive() {
        return hp > 0;
    }

    // false if character is alive, true if dead
    public boolean isDead() {
        return hp <= 0;
    }

    // returns a random number from 0 to 100
    public int getRandom() {
        Random random = new Random();
        return random.nextInt(100);
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
