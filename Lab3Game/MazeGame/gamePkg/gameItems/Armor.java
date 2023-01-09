package gamePkg.gameItems;

public class Armor extends gamePkg.abstractions.Armor {

    private int strength;

    public Armor(int strength) {
        this.strength = strength;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public void absorbDamage(int damage) {
        strength -= damage;
        if(strength < 0) strength = 0;
    }

    @Override
    public boolean isFull() {
        return this.strength > 0;
    }

    public String getName() {
        switch (this.strength) {
            case 20 -> {
                return "Слабая броня.";
            }
            case 50 -> {
                return "Средняя броня.";
            }
            case 100 -> {
                return "Сильная броня.";
            }
        }
        return "";
    }
}
