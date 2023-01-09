package gamePkg.maze;

import gamePkg.abstractions.MazeFabric;
import gamePkg.enums.Direction;
import gamePkg.room.Room;

import java.util.ArrayList;

public class MazeGame {
    public Maze createMaze(MazeFabric factory, int roomFrom, int roomTo) {
        var aMaze = factory.makeMaze();

        var rooms = new ArrayList<Room>(roomTo);

        for(int i = roomFrom; i <= roomTo; i++)
            rooms.add(factory.makeRoom(i));

        var theDoor = factory.makeDoor(rooms.get(0), rooms.get(1));

        rooms.get(0).setSide(Direction.NORTH, factory.makeWall());
        rooms.get(0).setSide(Direction.SOUTH, theDoor);
        rooms.get(0).setSide(Direction.WEST, factory.makeWall());
        rooms.get(0).setSide(Direction.EAST, factory.makeWall());

        rooms.get(1).setSide(Direction.NORTH, theDoor);
        rooms.get(1).setSide(Direction.SOUTH, factory.makeWall());
        rooms.get(1).setSide(Direction.WEST, factory.makeWall());
        rooms.get(1).setSide(Direction.EAST, factory.makeWall());

        for(int i = 2; i < rooms.size(); i++) {
            theDoor = factory.makeDoor(rooms.get(i-1), rooms.get(i));
            rooms.get(i-1).setSide(Direction.SOUTH, theDoor);

            rooms.get(i).setSide(Direction.NORTH, theDoor);
            rooms.get(i).setSide(Direction.SOUTH, factory.makeWall());
            rooms.get(i).setSide(Direction.WEST, factory.makeWall());
            rooms.get(i).setSide(Direction.EAST, factory.makeWall());

        }

        rooms.get(roomTo-1).haveAPortal = true;

        for(var room : rooms)
            aMaze.addRoom(room);

        return aMaze;
    }
}
