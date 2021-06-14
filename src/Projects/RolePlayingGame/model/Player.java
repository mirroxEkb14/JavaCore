package Projects.RolePlayingGame.model;

import Projects.RolePlayingGame.util.PlayerKind;

    /*
        Player is an entity, so we 'extends Entity'
    */

public abstract class Player extends Entity {

    HealingPotion potion;

    public Player(String name, PlayerKind kind) {
        // call 'Entity' constructor
        super(name, kind);
    }

    // if the merchant did not sell a potion, returns false
    // if sold, two cases:
    //              1. hero`s HP <= 50, then we heal him
    //              2. hero`s HP > 50, then we decrease from max hero health(100) the current hero`s HP, then add to the current HP
    //                  Example: hero`s hp is 60, then 100 - 60 = 40, so we must heal 40, then 60 + 40 = 100(100 - max hero`s HP)
    public boolean drinkPotion() {
        if (potion == null) return false;

        this.setHp(heal() < 100 ? heal() : getHp() + (100 - getHp()));
        return true;
    }

    private int heal() {
        return this.getHp() + potion.getHealing();
    }

    //setter
    public void setPotion(HealingPotion potion) {
        this.potion = potion;
    }
}
