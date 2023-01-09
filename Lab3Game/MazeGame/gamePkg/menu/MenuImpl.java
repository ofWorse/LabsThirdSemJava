package gamePkg.menu;

import gamePkg.IMenu;
import gamePkg.enums.NumberMenu;
import gamePkg.enums.Situation;
import gamePkg.gameItems.*;
import gamePkg.impl.AuxiliaryMethods;
import gamePkg.impl.BackPackImpl;
import gamePkg.impl.PlayerImpl;
import gamePkg.room.Door;
import gamePkg.room.Room;

import java.util.List;

public class MenuImpl implements IMenu {
    MenuSelectImpl menu;
    MenuOfDescriptions descriptions;
    PlayerImpl player;

    public MenuImpl() {
        menu = new MenuSelectImpl();
        descriptions = new MenuOfDescriptions();
    }

    @Override
    public void startMenu() {
        final int START = 1;
        final int EXIT = 2;
        final int RULES = 3;
        int userChoice;

        do {
            menu.menuSelect(NumberMenu.START_MENU);
            userChoice = AuxiliaryMethods.inputProtection(START, RULES);

            if (userChoice == EXIT)
                System.exit(1);
            else if (userChoice == RULES)
                menu.menuSelect(NumberMenu.RULES_MENU);
        } while (userChoice != START);
    }

    @Override
    public void roomEntryMenu(Room room) {
        final int LOOK_AROUND = 1;
        final int IGNORE = 2;
        int userChoice;
        menu.menuSelect(NumberMenu.ROOM_ENTRY_MENU);
        if (!room.isAttended) {
            do {
                menu.menuSelect(NumberMenu.LOOK_AROUND_MENU);
                userChoice = AuxiliaryMethods.inputProtection(LOOK_AROUND, IGNORE);

                switch (userChoice) {
                    case LOOK_AROUND -> descriptions.describeTheSituation(Situation.ROOM_DESCRIPTION);
                    case IGNORE -> descriptions.describeTheSituation(Situation.IGNORED);
                }
            } while (userChoice != LOOK_AROUND);
        }
    }

    @Override
    public boolean doorMenu(Door door) {
        final int GO_THROUGH = 1;
        final int IGNORE = 2;
        int userChoice;
        descriptions.describeTheSituation(Situation.DOOR_DESCRIPTION);
        menu.menuSelect(NumberMenu.DOOR_MENU);
        userChoice = AuxiliaryMethods.inputProtection(GO_THROUGH, IGNORE);
        switch (userChoice) {
            case GO_THROUGH -> {
                if (door.active) {
                    player.setTheAttendedDoor(door);
                    door.getFirstRoom().isAttended = true;
                    player.act(door.getSecondRoom());
                    System.out.println("\nВы перешли в другую комнату.");
                    return true;
                } else {
                    System.out.println("\nВы не можете перейти в другую комнату пока рядом монстр!");
                    return false;
                }
            }
            case IGNORE -> {
                descriptions.describeTheSituation(Situation.IGNORED);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean itemsMenu(Object item, boolean fromBackPack) {
        if (fromBackPack) {
            if (item instanceof Armor) {
                menu.menuSelect(NumberMenu.ARMOR_MENU2);
                itemOperations(item);
            } else if (item instanceof Weapon) {
                menu.menuSelect(NumberMenu.WEAPON_MENU2);
                itemOperations(item);
            }
        } else {
            if (item instanceof Armor) {
                menu.menuSelect(NumberMenu.ARMOR_MENU);
                itemOperations(item);
            } else if (item instanceof Weapon) {
                menu.menuSelect(NumberMenu.WEAPON_MENU);
                itemOperations(item);
            }
        }
        return true;
    }

    private void itemOperations(Object item) {
        final int TAKE_ITEM = 1;
        final int IGNORE_ITEM = 2;
        final int PUT_ITEM = 3;
        int userChoice = AuxiliaryMethods.inputProtection(TAKE_ITEM, PUT_ITEM);
        if (userChoice == TAKE_ITEM) {
            takeItemMenu(item);
        } else if (userChoice == IGNORE_ITEM) {
            descriptions.describeTheSituation(Situation.IGNORED);
        } else if (userChoice == PUT_ITEM) {
            player.backPack.putItem(item);
        }
    }

    private void takeItemMenu(Object item) {
        player.pickUpItem(item);
    }

    @Override
    public void fightMenu(Monster monster) {
        final int ACCEPT_FIGHT = 1;
        final int RUN_AWAY = 2;
        int userChoice;
        menu.menuSelect(NumberMenu.ACCEPT_FIGHT_MENU);
        userChoice = AuxiliaryMethods.inputProtection(ACCEPT_FIGHT, RUN_AWAY);
        switch (userChoice) {
            case ACCEPT_FIGHT -> fight(monster);
            case RUN_AWAY -> {
                if (player.attendedDoors.isEmpty()) {
                    System.out.println("\nПозади вас нет дургих комнат!\n");
                    fight(monster);
                } else {
                    player.toThePreviousDoor().getSecondRoom().isAttended = true;
                    player.toThePreviousDoor().getFirstRoom().isAttended = true;
                    player.act(player.toThePreviousDoor().getFirstRoom());
                    player.removeLastDoor();
                    return;
                }
            }
        }
        fightResultMenu(monster);
    }

    private void fight(Monster monster) {
        final int MAKE_A_STRIKE = 1, PARRY_ATTACK = 2, DEFEND_ATTACK = 3;
        do {
            menu.menuSelect(NumberMenu.FIGHT_MENU);
            int userChoice = AuxiliaryMethods.inputProtection(MAKE_A_STRIKE, DEFEND_ATTACK);
            switch (userChoice) {
                case MAKE_A_STRIKE -> player.attack(monster);
                case PARRY_ATTACK -> player.parryAttack(monster);
                case DEFEND_ATTACK -> player.defend(monster);
            }
            monster.makeTurn(player);
            player.getInfo();
        } while (player.isAlive() && monster.isAlive());

    }

    private void fightResultMenu(Monster monster) {
        if (monster.isAlive()) {
            descriptions.describeTheSituation(Situation.YOU_ARE_DEAD);
            System.exit(-1);
        } else {
            descriptions.describeTheSituation(Situation.MONSTER_IS_DEAD);
            this.player.getInfo();
        }
    }

    public boolean portalMenu(Portal portal) {
        final int EXTRACT = 1;
        final int IGNORE = 2;
        int userChoice;
        descriptions.describeTheSituation(Situation.PORTAL_DESCRIPTION);
        menu.menuSelect(NumberMenu.PORTAL_MENU);
        userChoice = AuxiliaryMethods.inputProtection(EXTRACT, IGNORE);
        if (userChoice == EXTRACT && portal.active) {
            portal.quitGame();
            return true;
        } else {
            if (userChoice == EXTRACT) System.out.println("\nПортал не активен!");
            else descriptions.describeTheSituation(Situation.IGNORED);
            return false;
        }
    }

    private boolean scrollerMenu(ScrollOfMagic scroll, boolean fromBackPack) {
        final int TAKE_ITEM = 1;
        final int IGNORE_ITEM = 2;
        final int PUT_ITEM = 3;
        int userChoice;
        if (fromBackPack) {
            menu.menuSelect(NumberMenu.SCROLLER_MENU2);
            userChoice = AuxiliaryMethods.inputProtection(TAKE_ITEM, IGNORE_ITEM);
        } else {
            menu.menuSelect(NumberMenu.SCROLLER_MENU);
            userChoice = AuxiliaryMethods.inputProtection(TAKE_ITEM, PUT_ITEM);
        }
        switch (userChoice) {
            case TAKE_ITEM -> {
                takeItemMenu(scroll);
                return true;
            }
            case IGNORE_ITEM -> {
                descriptions.describeTheSituation(Situation.IGNORED);
                return false;
            }
            case PUT_ITEM -> {
                player.backPack.putItem(scroll);
                return true;
            }
        }
        return false;
    }

    private void backPackMenu(BackPackImpl backPack) {
        final int CANCELLATE = 0, ACTIVATE = 1, DROP = 2;
        int END, START = 1;
        int selectedItem, userChoice;
        do {
            END = backPack.backpack.size();
            backPack.showItems();
            menu.menuSelect(NumberMenu.BACKPACK_START_MENU);
            selectedItem = AuxiliaryMethods.inputProtection(CANCELLATE, END);
            if (selectedItem >= START && selectedItem <= END) {
                Object item = backPack.getItem(selectedItem - 1);
                menu.menuSelect(NumberMenu.BACKPACK_ACT_MENU);
                userChoice = AuxiliaryMethods.inputProtection(ACTIVATE, DROP);
                switch (userChoice) {
                    case ACTIVATE -> {
                        if (interact(item, true))
                            backPack.dropItem(selectedItem - 1);
                    }
                    case DROP -> {
                        descriptions.describeTheSituation(Situation.YOU_DROPPED_THE_ITEM);
                        backPack.dropItem(selectedItem - 1);
                    }
                }
            }
        } while (selectedItem != CANCELLATE);
    }

    public void showInfo(List<Object> gameObjects, Room room, PlayerImpl player) {
        final int ACCEPT = 1;
        final int DISMISS = 2;
        int BACKPACK;
        int userChoice;
        this.player = player;
        if (gameObjects.isEmpty()) descriptions.describeTheSituation(Situation.ROOM_IS_EMPTY);
        else {
            if (!room.isAttended) {
                do {
                    menu.menuSelect(NumberMenu.ITEMS_MENU);
                } while (AuxiliaryMethods.inputProtection(ACCEPT, DISMISS) != ACCEPT);
            }
            do {
                BACKPACK = gameObjects.size() + 1;
                descriptions.describeTheSituation(Situation.ROOM_IS_NOT_EMPTY);

                MenuUtils.getListOfItems(gameObjects, BACKPACK);

                userChoice = AuxiliaryMethods.inputProtection(1, BACKPACK);
                if (userChoice == BACKPACK)
                    interact(player.backPack, true);
                else if (interact(gameObjects.get(userChoice - 1), false))
                    gameObjects.remove(userChoice - 1);
            } while (!gameObjects.isEmpty());
        }
    }

    private boolean interact(Object obj, boolean fromBackPack) {
        if (obj instanceof BackPackImpl)
            backPackMenu((BackPackImpl) obj);
        else if (obj instanceof Monster)
            fightMenu((Monster) obj);
        else if (obj instanceof Armor)
            return itemsMenu(obj, fromBackPack);
        else if (obj instanceof Weapon)
            return itemsMenu(obj, fromBackPack);
        else if (obj instanceof ScrollOfMagic)
            return scrollerMenu((ScrollOfMagic) obj, fromBackPack);
        else if (obj instanceof Door)
            return doorMenu((Door) obj);
        else if (obj instanceof Portal)
            return portalMenu((Portal) obj);
        return true;
    }
}
