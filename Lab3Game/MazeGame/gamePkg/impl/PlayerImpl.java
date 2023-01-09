package gamePkg.impl;

import gamePkg.IPlayer;
import gamePkg.abstractions.Armor;
import gamePkg.abstractions.Monster;
import gamePkg.abstractions.Weapon;
import gamePkg.gameItems.ScrollOfMagic;
import gamePkg.menu.MenuImpl;
import gamePkg.room.Door;
import gamePkg.room.Room;

import java.util.ArrayList;
import java.util.List;

public class PlayerImpl implements IPlayer {

    public int hp;
    public int points;
    public BackPackImpl backPack;
    public List<Door> attendedDoors;
    Weapon weapon;
    Armor armor;
    MenuImpl menu;

    public PlayerImpl(int hp, int points) {
        this.hp = hp;
        this.points = points;
        this.backPack = new BackPackImpl();
        attendedDoors = new ArrayList<>();
        weapon = new gamePkg.gameItems.Weapon(10);
        armor = new gamePkg.gameItems.Armor(10);
        menu = new MenuImpl();
    }

    public void getInfo() {
        System.out.println("\n (0 _ 0)\n [ (hp)" + hp + " (pts)" + points + " (armor)" + armor.getStrength() + " (weapon)" + weapon.getDamage() + " ]");
    }

    @Override
    public void sendAction(Monster monster, int param, boolean attack) {
        monster.getActionFrom(this, param, attack);
    }

    @Override
    public void getActionFrom(Monster monster, int param, boolean attack) {
        if (attack)
            absorbDamage(param);
        else System.out.println("\n (0 о 0) Тебе меня не преодолеть!");
    }

    @Override
    public void attack(Monster monster) {
        if (monster.isAlive()) {
            sendAction(monster, this.weapon.getDamage(), true);
            this.points++;
        } else System.out.println(" (0 _0) Наконец, этот бой окончен.");
    }


    @Override
    public void defend(Monster monster) {
        if (!this.armor.isFull())
            sendAction(monster, this.armor.getStrength(), false);
        else sendAction(monster, this.hp, false);
    }

    @Override
    public void parryAttack(Monster monster) {
        this.hp += monster.getDamage();
        System.out.println("\n (0 ^0) Я уклонился от атаки!");
    }

    public void absorbDamage(int damage) {
        System.out.println(" (> _<) МОНСТР ПОПАЛ ПО МНЕ!!!");
        if (this.armor.isFull()) this.armor.absorbDamage(damage);
        else this.hp -= damage;
    }

    @Override
    public boolean isAlive() {
        return hp >= 0;
    }

    @Override
    public void pickUpItem(Object item) {
        if (item instanceof Armor) {
            this.armor = (Armor) item;
            System.out.println(" (0 ^ 0) Я подобрал " + this.armor.getName());
        } else if (item instanceof Weapon) {
            this.weapon = (Weapon) item;
            System.out.println(" (0 ^ 0) Я подобрал " + this.weapon.getName());
        } else if (item instanceof ScrollOfMagic) {
            if (((ScrollOfMagic) item).getName().equals("Свиток здоровья"))
                this.hp += ((ScrollOfMagic) item).readTheScroll();
            else this.weapon.setDamage(((ScrollOfMagic) item).readTheScroll());
            System.out.println(" (0 ^ 0) Я прочёл " + ((ScrollOfMagic) item).getName() +
                    " (+" + ((ScrollOfMagic) item).getParam() + ").");
        }
        getInfo();
    }

   public void setTheAttendedDoor(Door door) {
        this.attendedDoors.add(door);
    }

    public Door toThePreviousDoor() {
        return this.attendedDoors.size() > 0 ? this.attendedDoors.get(attendedDoors.size() - 1) : null;
    }

    public void removeLastDoor() {
        this.attendedDoors.remove(attendedDoors.size() - 1);
    }

    public void act(Room room) {
        System.out.println("\n КОМНАТА №" + room.getRoomNumber());
        menu.roomEntryMenu(room);
        room.checkTheContents();
        menu.showInfo(room.listOfObjects, room, this);
    }
}
