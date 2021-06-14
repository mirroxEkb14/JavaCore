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
    }

    // method returns the amount of damage of the attacker
    @Override
    public int attack() {
        int randomNumber = getRandom(); // get a random number
        int currentAgility = getAgility(); // get agility

        // if the random number is greater or equals to the current entity agility AND the random number is greater than
        // the current agility plus ten, return the full entity strength, 0 otherwise(miss)
        return  randomNumber >= currentAgility && randomNumber < (currentAgility + 10) ? getForce() : 0;
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

    // increases the level, taking into account the amount of XP
    // with increasing hero level, we increase his stats
    public void levelUp() {
        int currentXp = getXp();

        level += currentXp - (currentXp / 100 * 99); // decrease 99% from XP

        // increase the stats by 20%
        float currentForce = getForce(); // 'float' because when we divide by 100 we get a float number
        force = Math.round(currentForce + (currentForce / 100 * 20));


        float currentAgility = getAgility();
        agility = Math.round(currentAgility + (currentAgility / 100 * 20));
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
