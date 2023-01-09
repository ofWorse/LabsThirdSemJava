package gamePkg.enums;

public enum NumberMenu {
    START_MENU(1), ROOM_ENTRY_MENU(2),
    LOOK_AROUND_MENU(3), ITEMS_MENU(4),
    FIGHT_MENU(5), ARMOR_MENU(6),
    WEAPON_MENU(7), DOOR_MENU(8),
    PORTAL_MENU(9), SCROLLER_MENU(10),
    BACKPACK_START_MENU(11), BACKPACK_ACT_MENU(12),
    WEAPON_MENU2(13), ARMOR_MENU2(14),
    SCROLLER_MENU2(14), ACCEPT_FIGHT_MENU(15),
    RULES_MENU(16);

    private int value;

    NumberMenu(int value) {
        this.value = value;
    }
}

