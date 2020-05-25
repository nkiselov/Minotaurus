package Mazes;

import MazeCoordinates.MazeCoordinate;

public interface Maze {
    public MazeType getMazeType();
    public void initialize(MazeOptions mazeOptions);
    public int[] getDirections();
    public int[] getOpposites();
    public void removeWall(MazeCoordinate mc, int directionIndex);
    public MazeCoordinate move(MazeCoordinate mc, int directionIndex);
    public boolean inside(MazeCoordinate mc);
    public int getValue(MazeCoordinate mc);
    public MazeCoordinate getStart();
    public MazeCoordinate getFinish();
}
