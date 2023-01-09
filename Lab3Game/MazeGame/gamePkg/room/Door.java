package gamePkg.room;

import gamePkg.abstractions.MapSite;

public class Door extends MapSite {

    private Room room1;
    private Room room2;

    public boolean active;

    public Door(Room room1, Room room2) {
        this.room1 = room1;
        this.room2 = room2;
        this.active = false;
    }


    public Room getSecondRoom() {
        return room2;
    }

    public Room getFirstRoom() {
        return room1;
    }

    @Override
    protected void enter() {

    }
}
