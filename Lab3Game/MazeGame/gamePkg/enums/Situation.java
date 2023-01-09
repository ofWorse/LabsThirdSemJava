package gamePkg.enums;

public enum Situation {
    ROOM_DESCRIPTION(1),
    WALL_DESCRIPTION(2),
    DOOR_DESCRIPTION(3),
    ENEMY_DESCRIPTION(4),
    PORTAL_DESCRIPTION(5),
    FIGHT_RESULT_DESCRIPTION(6),
    IGNORED(7),
    ROOM_IS_EMPTY(8),
    ROOM_IS_NOT_EMPTY(9),
    YOU_ARE_DEAD(10),
    MONSTER_IS_DEAD(11),
    YOU_DROPPED_THE_ITEM(12);

    public int value;
    Situation(int value) {
        this.value = value;
    }
}
