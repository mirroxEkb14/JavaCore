package Generics.СlassParameterization.Characters;

import Generics.СlassParameterization.WeaponsInterfaces.MagicWeapon;

public class Mage<T extends MagicWeapon> extends Hero<T> {

    public Mage(String name, int damage) {
        super(name, damage);
    }
}
