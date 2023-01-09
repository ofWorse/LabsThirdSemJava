package gamePkg.abstractions;

import gamePkg.maze.Maze;
import gamePkg.room.Door;
import gamePkg.room.Room;
import gamePkg.room.Wall;

public abstract class MazeFabric {
    public abstract Maze makeMaze();
    public abstract Wall makeWall();
    public abstract Room makeRoom(int n);
    public abstract Door makeDoor(Room r1, Room r2);
}
