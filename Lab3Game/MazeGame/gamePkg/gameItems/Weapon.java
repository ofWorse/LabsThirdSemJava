package gamePkg.gameItems;

public class Weapon extends gamePkg.abstractions.Weapon {

    private int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage += damage;
    }
    public String getName() {
        switch (this.damage) {
            case 20 -> {
                return "Слабый меч.";
            }
            case 50 -> {
                return "Средний меч.";
            }
            case 100 -> {
                return "Сильный меч.";
            }
        }
        return "";
    }
}
