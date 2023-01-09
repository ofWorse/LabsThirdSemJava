package gamePkg;

import gamePkg.abstractions.ScrollOfMagic;

public interface IMagicScrollFabric {
    ScrollOfMagic createDamageScroll();
    ScrollOfMagic createHealthScroll();
}
