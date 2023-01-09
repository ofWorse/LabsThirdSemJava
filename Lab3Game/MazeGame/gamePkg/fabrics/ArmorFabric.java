package gamePkg.fabrics;

import gamePkg.IArmorsFabric;
import gamePkg.gameItems.Armor;

public class ArmorFabric implements IArmorsFabric {

    @Override
    public Armor createWeakArmor() {
        return new Armor(20);
    }

    @Override
    public Armor createAverageArmor() {
        return new Armor(50);
    }

    @Override
    public Armor createSuperArmor() {
        return new Armor(100);
    }
}
