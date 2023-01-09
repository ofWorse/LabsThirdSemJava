package gamePkg.impl;

import gamePkg.fabrics.MazeFabric;
import gamePkg.maze.Maze;
import gamePkg.maze.MazeGame;
import gamePkg.menu.MenuImpl;

import java.util.Random;

public class Game {

    private MenuImpl menu;
    private PlayerImpl player;
    private MazeGame mazeGame;
    private Maze maze;

    public Game() {
        menu = new MenuImpl();
        maze = new Maze();
        mazeGame = new MazeGame();
        this.player = new PlayerImpl(1000, 0);
    }

    public void startGame() {
        maze = mazeGame.createMaze(new MazeFabric(), 1, new Random().nextInt(10) + 3);
        menu.startMenu();
        player.act(maze.getRoomFromNumber(1));
    }
}
