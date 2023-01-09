package gamePkg.fabrics;

import gamePkg.IMagicScrollFabric;
import gamePkg.gameItems.ScrollOfMagic;

import java.util.Random;

public class MagicScrollsFabric implements IMagicScrollFabric {
    @Override
    public ScrollOfMagic createDamageScroll() {
        return new ScrollOfMagic("Свиток урона", new Random().nextInt(100));
    }

    @Override
    public ScrollOfMagic createHealthScroll() {
        return new ScrollOfMagic("Свиток здоровья", new Random().nextInt(100));
    }
}
