package gamePkg;

import gamePkg.abstractions.Weapon;

public interface IWeaponsFabric {
    Weapon createWeakWeapon();
    Weapon createAverageWeapon();
    Weapon createSuperWeapon();
}
