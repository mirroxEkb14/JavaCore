package Generics.–°lassParameterization.Characters;

import Generics.–°lassParameterization.WeaponsInterfaces.MagicWeapon;

public class Mage<T extends MagicWeapon> extends Hero<T> {

    public Mage(String name, int damage) {
        super(name, damage);
    }
}
