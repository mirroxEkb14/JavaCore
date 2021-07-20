package Projects.WitcherInventory.model.Character;

import Projects.WitcherInventory.model.Inventory;
import Projects.WitcherInventory.util.Consumable.BombItems;

import java.util.ArrayList;
import java.util.List;

public class Bombs {
    private static final List<BombItems> bombSlot = new ArrayList<>(2);

    public void setSlotFirst(BombItems item) {

        bombSlot.set(0, item);
    }
    public void setSlotSecond(BombItems item) {
        bombSlot.set(1, item);
    }
}
