package gamePkg.room;

import gamePkg.abstractions.MapSite;
import gamePkg.enums.Direction;
import gamePkg.fabrics.ArmorFabric;
import gamePkg.fabrics.MagicScrollsFabric;
import gamePkg.fabrics.MonsterFabric;
import gamePkg.fabrics.WeaponFabric;
import gamePkg.gameItems.Portal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Room {

    public boolean haveAMonster = new Random().nextBoolean();
    public boolean haveAArmor = new Random().nextBoolean();
    public boolean haveAWeapon = new Random().nextBoolean();
    public boolean haveAScroller = new Random().nextBoolean();
    public boolean haveAPortal;
    public boolean isAttended = false;
    private final int roomNumber;
    private final Hashtable<Direction, MapSite> sideOfRoom;
    public List<Object> listOfObjects;

    public Room(int roomNumber) {
        sideOfRoom = new Hashtable<>(4);
        this.roomNumber = roomNumber;
        haveAPortal = false;
        listOfObjects = new ArrayList<>();
    }

    public void setSide(Direction dir, MapSite ms) {
        sideOfRoom.put(dir, ms);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void checkTheContents() {
        if(!isAttended) {
            if (haveAMonster) this.listOfObjects.add(getContent(new MonsterFabric()));
            if (haveAArmor) this.listOfObjects.add(getContent(new ArmorFabric()));
            if (haveAWeapon) this.listOfObjects.add(getContent(new WeaponFabric()));
            if (haveAScroller) this.listOfObjects.add(getContent(new MagicScrollsFabric()));
            if (haveAPortal) this.listOfObjects.add(getContent(new Portal()));
            this.listOfObjects.add(sideOfRoom.get(Direction.SOUTH));
        }
    }

    private Object getContent(Object o) {

        if (o instanceof MonsterFabric) {
            int random = new Random().nextInt(3);
            MonsterFabric mf = new MonsterFabric();
            switch (random) {
                case 0:
                    return mf.createWeakMonster();
                case 1:
                    return mf.createAverageMonster();
                case 2:
                    return mf.createSuperMonster();
            }
        } else if (o instanceof WeaponFabric) {
            int random = new Random().nextInt(3);
            WeaponFabric wf = new WeaponFabric();
            switch (random) {
                case 0:
                    return wf.createWeakWeapon();
                case 1:
                    return wf.createAverageWeapon();
                case 2:
                    return wf.createSuperWeapon();
            }
        } else if (o instanceof ArmorFabric) {
            int random = new Random().nextInt(3);
            ArmorFabric af = new ArmorFabric();
            switch (random) {
                case 0:
                    return af.createWeakArmor();
                case 1:
                    return af.createAverageArmor();
                case 2:
                    return af.createSuperArmor();
            }
        } else if (o instanceof MagicScrollsFabric) {
            int random = new Random().nextInt(2);
            MagicScrollsFabric msf = new MagicScrollsFabric();
            switch (random) {
                case 0:
                    return msf.createDamageScroll();
                case 1:
                    return msf.createHealthScroll();
            }
        } else if (o instanceof Portal) {
            return new Portal();
        }
        return null;
    }
}
