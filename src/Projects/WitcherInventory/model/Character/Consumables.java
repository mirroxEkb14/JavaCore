package Projects.WitcherInventory.model.Character;

import Projects.WitcherInventory.util.Bag.FoodAndDrinkItems;
import Projects.WitcherInventory.util.Consumable.PotionItems;

import java.util.ArrayList;
import java.util.List;

public class Consumables {
    private static final List<Object> slot1 = new ArrayList<>(2);
    private static final List<Object> slot2 = new ArrayList<>(2);

    public void addToOne(FoodAndDrinkItems item) { slot1.add(item); }
    public void addToOne(PotionItems item) { slot1.add(item); }

    public void addToTwo(FoodAndDrinkItems item) { slot2.add(item); }
    public void addToTwo(PotionItems item) { slot2.add(item); }

    public List<Object> getSlot1() { return slot1; }
    public Object getSlot1First() { return slot1.get(0); }
    public Object getSlot1Second() { return slot1.get(1); }

    public List<Object> getSlot2() { return slot2; }
    public Object getSlot2First() { return slot2.get(0); }
    public Object getSlot2Second() { return slot2.get(1); }
}
