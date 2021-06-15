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
    public void levelUp() {
        int currentXP = getXP();

        // how many levels to increase
        int levelsToUp = currentXP / 100;

        // there are levels to increase
        if (levelsToUp >= 1) {
            setLevel(getLevel() + levelsToUp);

            // if there are levels to increase, we set xp to zero, after increase xp by the numbers after ','
            // after defeating a monster, in the 'BattleField' class we set hero xp to the sum of
            // current hero xp and monster xp, then we call this method, for example, hero xp is 20,
            // monster`s - 120, in the 'BattleField' class we set hero xp to 140(20 + 120), then call this method
            // where we divide 140 by 100 and get 1.40(1 - levels to increase, 40 - xp to set)
            setXP(currentXP % 100);

        // if there are not(the sum of xp < 100), we just set hero xp to this sum
        } else {
            setXP(currentXP);
        }


        // increase the stats(force, agility, HP) by 20%
        float currentForce = getForce(); // 'float' because when we divide by 100 we get a float number
        setForce(Math.round(currentForce + (currentForce / 100 * 20)));


        float currentAgility = getAgility();
        setAgility(Math.round(currentAgility + (currentAgility / 100 * 20)));

        // when leveling up, the current incomplete HP is increased by 20%,
        // also the max amount of HP is increased by 20%
        float currentHp = getHP();
        setHP(Math.round(currentHp + (currentHp / 100 * 20)));
        maxHP += maxHP / 100 * 20;
    }

    // if the merchant did not sell a potion, returns false
    // if sold, two cases:
    //     1. hero`s HP <= 50, then we heal him
    //     2. hero`s HP > 50, then we decrease from max hero health(100) the current hero`s HP, then add to the current HP
    //         Example: hero`s hp is 60, then 100 - 60 = 40, so we must heal 40, then 60 + 40 = 100(100 - max hero`s HP)
    public boolean drinkPotion() {
        if (potions.isEmpty()) return false;

        setHP(heal() < maxHP ? heal() : getHP() + (maxHP - getHP()));
        potions.remove(0); // remove from the list the used potion
        return true;
    }

    // add 50 to the current hero hp(potion heals 50)
    private int heal() {
        return getHP() + potions.get(0).getHealing();
    }

    // print all the information about the hero
    public void printStatistic() {
        System.out.printf("Name: %s\nLevel: %d\nCondition: %s\nMax HP: %d\nCurrent HP: %d\nForce: %d\nAgility: %d\nXP: %d\nGold: %d\nPotions: %d\n",
                this.getName(), this.getLevel(), this.isAlive()? "Alive": "Dead", maxHP, this.getHP(), this.getForce(),
                this.getAgility(), this.getXP(), this.getGold(), potions.size());
    }

    // setter
    public void setPotion(HealingPotion potion) {
        if (potion != null) potions.add(potion); // if the user was able to buy a potion
    }
}
