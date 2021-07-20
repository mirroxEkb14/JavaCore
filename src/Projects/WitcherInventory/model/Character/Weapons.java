package Projects.WitcherInventory.model.Character;

import Projects.WitcherInventory.util.Gear.WeaponItems;

import java.util.List;

public class Weapons {
    private static WeaponItems steelSword;
    private static WeaponItems silverSword;
    private static WeaponItems bolts;
    private static WeaponItems rangedWeapon;

    public void setSteelSword(WeaponItems steelSword) { Weapons.steelSword = steelSword; }
    public void setSilverSword(WeaponItems silverSword) { Weapons.silverSword = silverSword; }
    public void setBolts(WeaponItems bolts) { Weapons.bolts = bolts; }
    public void setRangedWeapon(WeaponItems rangedWeapon) { Weapons.rangedWeapon = rangedWeapon; }

    public WeaponItems getSteelSword() { return steelSword; }
    public WeaponItems getSilverSword() { return silverSword; }
    public WeaponItems getBolts() { return bolts; }
    public WeaponItems getRangedWeapon() { return rangedWeapon; }

    public List<WeaponItems> getWeapons() { return List.of(steelSword, silverSword, bolts, rangedWeapon); }
}
