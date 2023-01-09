package gamePkg;

import gamePkg.abstractions.Armor;

public interface IArmorsFabric {
    Armor createWeakArmor();
    Armor createAverageArmor();
    Armor createSuperArmor();
}
