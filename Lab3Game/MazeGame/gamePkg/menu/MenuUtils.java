package gamePkg.menu;

import gamePkg.gameItems.*;
import gamePkg.room.Door;

import java.util.List;

public class MenuUtils {
    public static String getObjectName(Object obj) {
        if(obj instanceof Armor)
            return ((Armor) obj).getName();
        else if(obj instanceof Weapon)
            return ((Weapon) obj).getName();
        else if(obj instanceof ScrollOfMagic)
            return ((ScrollOfMagic) obj).getName();
        else if(obj instanceof Monster) {
            return ((Monster) obj).getName();
        }
        return "";
    }

    public static void getListOfItems(List<Object> gameObjects, int BACKPACK) {
        boolean notify = false;
        int i = 1;
        for (var obj : gameObjects) {
            if (obj instanceof Monster) {
                System.out.println(i + ") " + MenuUtils.getObjectName(obj));
                notify = true;
            } else if (obj instanceof Armor)
                System.out.println(i + ") " + MenuUtils.getObjectName(obj));
            else if (obj instanceof Weapon)
                System.out.println(i + ") " + MenuUtils.getObjectName(obj));
            else if (obj instanceof Door) {
                if (!notify) {
                    System.out.println(i + ") Дверь.");
                    ((Door) obj).active = true;
                } else System.out.println(i + ") Дверь. *закрыто*");
            } else if (obj instanceof Portal) {
                if (!notify) {
                    System.out.println(i + ") Портал.");
                    ((Portal) obj).active = true;
                }
                else System.out.println(i + ") Портал. *неактивен*");
            } else if(obj instanceof ScrollOfMagic)
                System.out.println(i + ") " + MenuUtils.getObjectName(obj));
            i++;
        }
        System.out.println("-----+-----");
        System.out.println(BACKPACK + ") Рюкзак.");
    }
}
