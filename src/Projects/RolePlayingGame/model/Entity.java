package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.Fighter;
import Projects.RolePlayingGame.util.MonsterKind;
import Projects.RolePlayingGame.util.PlayerKind;

import java.util.Random;

public abstract class Entity implements Fighter {

    private String name;
    private int level;
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
        level = 0;
        hp = 100;
        xp = 0;
        gold = 0;
    }

    // constructor for monster
    public Entity(MonsterKind kind) {

        // if it is a goblin
        if (kind.equals(MonsterKind.GOBLIN)) {
            name = "Goblin";
            level = 1;
            hp = 100;
            force = 20;
            agility = 25;
            xp = 100;
            gold = 100;

        // if a skeleton
        } else if (kind.equals(MonsterKind.SKELETON)) {
            name = "Skeleton";
            level = 2;
            hp = 120;
            force = 25;
            agility = 20;
            xp = 200;
            gold = 150;

        // if a troll
        } else {
            name = "Troll";
            level = 3;
            hp = 150;
            force = 35;
            agility = 20;
            xp = 300;
            gold = 250;
        }

//        // skeleton has more force than a goblin
//        if (kind.equals(MonsterKind.SKELETON)) {
//            force = 25;
//            agility = 20;
//            name = "Skeleton";
//
//        } else { // but a goblin has more agility
//            force = 20;
//            agility = 25;
//            name = "Goblin";
//        }
//
//        // monster already has hp, xp and gold
//        level = 0;
//        hp = 100;
//        xp = 100;
//        gold = 100;
    }

    // method returns the amount of damage of the attacker
    @Override
    public int attack() {
        int randomNumber = getRandom(); // get a random number

        // if the entity agility is 20 and if a random number is generated in the range [20, 25) -> return full entity strength
        // if the entity agility is 25 and if a random number is generated in the range [25, 35) -> return full entity strength
        // the difference of 10 gives a greater chance for the entity with agility 25 to hit
        if (this.getAgility() == 20) {
            if (randomNumber >= 20 && randomNumber < 25) return this.getForce();
            else return 0;

        // this.getAgility() == 25
        } else {
            if (randomNumber >= 25 && randomNumber < 35) return this.getForce();
            else return 0;
        }
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
        System.out.printf("Name: %s\nLevel: %d\nCondition: %s\nForce: %d\nAgility: %d\nXP: %d\nGold: %d\n",
                this.getName(), this.getLevel(), this.isAlive()? "Alive": "Dead", this.getForce(),
                this.getAgility(), this.getXp(), this.getGold());
    }

    // false if character is dead, true if alive
    public boolean isAlive() {
        return hp > 0;
    }

    // false if character is alive, true if dead
    public boolean isDead() {
        return hp <= 0;
    }

    // returns a random number [20, 35]
    public int getRandom() {
        Random random = new Random();
        return 20 + random.nextInt(15);
    }

    // increases the level by 1
    public void levelUp() {
        level += 1;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
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
