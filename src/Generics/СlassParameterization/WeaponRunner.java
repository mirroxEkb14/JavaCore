package Generics.СlassParameterization;

import Generics.СlassParameterization.Characters.Archer;
import Generics.СlassParameterization.Characters.Mage;
import Generics.СlassParameterization.Characters.Warrior;
import Generics.СlassParameterization.WeaponsClasses.Bow;
import Generics.СlassParameterization.WeaponsClasses.Sword;
import Generics.СlassParameterization.WeaponsClasses.Wand;

public class WeaponRunner {

    public static void main(String[] args) {
        /*  We have a magician with a wand, warrior with a sword and archer with a bow;

            The necessity of using Generics here is that we forbid heroes
                to use weapons that do not match them, which means that
                a mage can only use a wand, a warrior can only use a sword, an archer can only use a bow  */


        /*  So, we need to create a "weapon" field in the "Hero" class, but what type will this field be?

            We have the "Bow", "Sword" and "Wand" classes and we want to create weapons with these types:
                private Bow weapon;
                private Sword weapon;
                private Wand weapon;

            without Generics we have to create fields for each type of weapon, which is irrational

            *see the "Hero" class  */

        Archer<Bow> archerExample = new Archer<>("ArcherExample", 5); // created an archer with a bow


        /*  But we still have a problem. The problem is that we can parameterized out Archer with any type
                (String, int, Sword, Wand, Double, whatever) but that is not what we want, because
                 we want an archer with a bow, only with a bow. So we have to forbid to pass any other types
                 except "Bow" for an archer, except "Sword" for a warrior, except "Wand" for a mage

                 *see the "Archer" class  */

//        Archer<String> strArcher = new Archer<>("StringArcher", 5);


        /* Now we got what we wanted. If you try something like this:
                Archer<Sword> archer = ...;
                archer.setWeapon(new Wand());

                Warrior<String> warrior = ...;
                warrior.setWeapon(new Bow());

                Mage<Bow> mage = ...;
                mage.setWeapon(new Sword());

                you will get compilation error  */

        Archer<Bow> archer = new Archer<>("Archer", 5);
        archer.setWeapon(new Bow());
        System.out.println(archer.getDamage());

        Warrior<Sword> warrior = new Warrior<>("Warrior", 10);
        warrior.setWeapon(new Sword());
        System.out.println(warrior.getDamage());

        Mage<Wand> mage = new Mage<>("Mage", 15);
        mage.setWeapon((new Wand()));
        System.out.println(mage.getDamage());


    }
}
