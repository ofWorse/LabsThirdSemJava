package gamePkg.maze;

import gamePkg.room.Room;

import java.util.Hashtable;

public class Maze {
    public Hashtable<Integer, Room> roomList;

    public Maze() {
        roomList = new Hashtable<>();
    }

    public void addRoom(Room room) {
        roomList.put(room.getRoomNumber(), room);
    }

    public Room getRoomFromNumber(int n) {
        return roomList.get(n);
    }
}
