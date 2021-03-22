package Generics.СlassParameterization.Characters;

import Generics.СlassParameterization.WeaponsInterfaces.RangeWeapon;

public class Archer<T extends RangeWeapon> extends Hero<T> {

    /*  <T extends RangeWeapon> means that we cannot pass any type, but only "RangeWeapon",
            because we want our archer with a bow, only with a bow(or with any range weapon).
            The same goes to Warrior and Mage  */

    public Archer(String name, int damage) {
        super(name, damage);
    }
}
