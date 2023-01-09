package gamePkg;

import gamePkg.gameItems.Monster;
import gamePkg.room.Door;
import gamePkg.room.Room;

public interface IMenu {
    void startMenu();
    void roomEntryMenu(Room room);
    boolean itemsMenu(Object item, boolean fromBackPack);
    boolean doorMenu(Door door);
    void fightMenu(Monster monster);

}
