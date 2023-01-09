package gamePkg;

import gamePkg.abstractions.Monster;

public interface IPlayer {
    void sendAction(Monster monster, int param, boolean attack);
    void getActionFrom(Monster monster, int param, boolean attack);
    void attack(Monster monster);
    void defend(Monster monster);
    void parryAttack(Monster monster);
    boolean isAlive();
    void pickUpItem(Object item);

}
