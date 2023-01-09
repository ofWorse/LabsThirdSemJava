package gamePkg.fabrics;

import gamePkg.IMonster;
import gamePkg.IMonstersFabric;
import gamePkg.gameItems.Monster;

public class MonsterFabric implements IMonstersFabric {

    @Override
    public IMonster createWeakMonster() {
        return new Monster(100, 10);
    }

    @Override
    public IMonster createAverageMonster() {
        return new Monster(500, 100);
    }

    @Override
    public IMonster createSuperMonster() {
        return new Monster(1000, 200);
    }
}
