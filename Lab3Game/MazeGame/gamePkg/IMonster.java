package gamePkg;

import gamePkg.impl.PlayerImpl;

public interface IMonster {
    void sendAction(PlayerImpl player, int param, boolean attack);
    void getActionFrom(PlayerImpl player, int param, boolean attack);
    void attack(PlayerImpl player);
    void runAway();
    int getDamage();
    void absorbDamage(int damage);
    boolean isAlive();
    String getName();
}
