package gamePkg.gameItems;

import gamePkg.impl.PlayerImpl;

import java.util.Random;

public class Monster extends gamePkg.abstractions.Monster {

    int hp, dmg, tiredOption;

    public Monster(int hp, int dmg) {
        super(hp, dmg);
        this.hp = hp;
        this.dmg = dmg;
    }

    @Override
    public int getDamage() {
        return this.dmg;
    }

    @Override
    public void absorbDamage(int damage) {
        this.hp -= damage;
    }

    @Override
    public void sendAction(PlayerImpl player, int param, boolean attack) {
        player.getActionFrom(this, param, attack);
    }

    @Override
    public void getActionFrom(PlayerImpl player, int param, boolean attack) {
        try {
            makeARandomMove(player, param, attack);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void makeARandomMove(PlayerImpl player, int param, boolean attack) throws InterruptedException {
        Thread.sleep(200);
        if (attack) {
            int randomAction = new Random().nextInt(2);
            switch (randomAction) {
                case 0 -> {
                    absorbDamage(param);
                    System.out.println("\n (Монстр) ТЫ ПОПАЛ ПО МНЕ!\n [ (hp)" + this.hp + ", (dmg)" + this.dmg + " ]\n");
                }
                case 1 -> {
                    tiredOption++;
                    if(tiredOption == 3) absorbDamage(param);
                    else System.out.println("\n (Монстр) ХА-ХА-ХА! Я ОТБИЛСЯ!\n [ (hp)" + this.hp + ", (dmg)" + this.dmg + " ]\n");
                }
            }

        } else {
            int randomAction = new Random().nextInt(3);
            switch (randomAction) {
                case 0 -> {
                    System.out.println("\n (Монстр) ПОЛУЧАЙ!\n");
                    attack(player);
                }
                case 1 -> {
                    System.out.println("\n (Монстр) ПОРА ВАЛИТЬ... НО ЭТО БЫЛ НЕ ПОСЛЕДНИЙ НАШ БОЙ!");
                    runAway();
                }
            }
        }
    }

    public void makeTurn(PlayerImpl player) {
        boolean b = new Random().nextBoolean();
        if (b) {
            attack(player);
        } else {
            System.out.println("\n (Монстр) ***делает замах***");
        }
    }

    @Override
    public void attack(PlayerImpl player) {
        sendAction(player, this.dmg, true);
    }


    @Override
    public void runAway() {
        this.hp = 0;
    }




    @Override
    public boolean isAlive() {
        return this.hp > 0;
    }

    @Override
    public String getName() {
        switch (this.hp) {
            case 100 -> {
                return "Слабый монстр.";
            }
            case 500 -> {
                return "Средний монстр.";
            }
            case 1000 -> {
                return "Сильный монстр.";
            }
        }
        return "";
    }
}
