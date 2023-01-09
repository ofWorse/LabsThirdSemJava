package gamePkg.fabrics;

import gamePkg.maze.Maze;
import gamePkg.room.Door;
import gamePkg.room.Room;
import gamePkg.room.Wall;

public class MazeFabric extends gamePkg.abstractions.MazeFabric {
    @Override
    public Maze makeMaze() {
        return new Maze();
    }

    @Override
    public Wall makeWall() {
        return new Wall();
    }

    @Override
    public Room makeRoom(int n) {
        return new Room(n);
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
