package gamePkg.abstractions;

import gamePkg.IMonster;

public abstract class Monster implements IMonster {
    int hp, dmg;
    public Monster(int hp, int dmg) {
        this.hp = hp;
        this.dmg = dmg;
    }
}
