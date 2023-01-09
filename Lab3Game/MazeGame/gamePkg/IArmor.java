package gamePkg;

public interface IArmor {
    int getStrength();
    void absorbDamage(int damage);
    boolean isFull();
    String getName();
}
