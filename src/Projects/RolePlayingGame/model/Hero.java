package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.PlayerKind;

import java.util.ArrayList;
import java.util.List;

    /*
         Hero is an entity, so we 'extends Entity'
    */

public class Hero extends Entity {

    List<HealingPotion> potions = new ArrayList<>(); // the hero can have a potion to heal
    int maxHP = 100; // max hero xp will be changed when leveling up

    public Hero(String nickName, PlayerKind kind) {
        // call 'Entity' constructor
        super(nickName, kind);
    }

    // increases the level, taking into account the amount of XP, also
    // with increasing hero level, we increase his stats
    public void levelUp(Monster monster) {

        int currentXp = monster.getXp();
        setLevel(getLevel() + (currentXp - (currentXp / 100 * 99))); // decrease 99% from monster XP

        // increase the stats(force, agility, HP) by 20%
        float currentForce = getForce(); // 'float' because when we divide by 100 we get a float number
        setForce(Math.round(currentForce + (currentForce / 100 * 20)));


        float currentAgility = getAgility();
        setAgility(Math.round(currentAgility + (currentAgility / 100 * 20)));

        // when leveling up, the current incomplete HP is increased by 20%,
        // also the max amount of HP is increased by 20%
        float currentHp = getHp();
        setHp(Math.round(currentHp + (currentHp / 100 * 20)));
        maxHP += maxHP / 100 * 20;
    }

    // if the merchant did not sell a potion, returns false
    // if sold, two cases:
    //     1. hero`s HP <= 50, then we heal him
    //     2. hero`s HP > 50, then we decrease from max hero health(100) the current hero`s HP, then add to the current HP
    //         Example: hero`s hp is 60, then 100 - 60 = 40, so we must heal 40, then 60 + 40 = 100(100 - max hero`s HP)
    public boolean drinkPotion() {
        if (potions.isEmpty()) return false;

        setHp(heal() < maxHP ? heal() : getHp() + (maxHP - getHp()));
        potions.remove(0); // remove from the list the used potion
        return true;
    }

    // add 50 to the current hero hp(potion heals 50)
    private int heal() {
        return getHp() + potions.get(0).getHealing();
    }

    // print all the information about the hero
    public void printStatistic() {
        System.out.printf("Name: %s\nLevel: %d\nCondition: %s\nMax HP: %d\nCurrent HP: %d\nForce: %d\nAgility: %d\nXP: %d\nGold: %d\nPotion: %d\n",
                this.getName(), this.getLevel(), this.isAlive()? "Alive": "Dead", maxHP, this.getHp(), this.getForce(),
                this.getAgility(), this.getXp(), this.getGold(), potions.size());
    }

    // setter
    public void setPotion(HealingPotion potion) {
        potions.add(potion);
    }
}
