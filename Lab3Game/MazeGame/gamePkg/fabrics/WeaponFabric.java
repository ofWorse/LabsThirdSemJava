package gamePkg.fabrics;

import gamePkg.IWeaponsFabric;
import gamePkg.gameItems.Weapon;

public class WeaponFabric implements IWeaponsFabric {
    @Override
    public Weapon createWeakWeapon() {
        return new Weapon(20);
    }

    @Override
    public Weapon createAverageWeapon() {
        return new Weapon(50);
    }

    @Override
    public Weapon createSuperWeapon() {
        return new Weapon(100);
    }
}
