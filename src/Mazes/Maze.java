package Mazes;

import MazeCoordinates.Border;
import MazeCoordinates.MazeCoordinate;

import java.util.List;

public interface Maze {
    public MazeType getMazeType();
    public void initialize(MazeOptions mazeOptions);
    public int[] getDirections();
    public int[] getOpposites();
    public List<Border> getAllBorders();
    public int getTotalCells();
    public int uniqueId(MazeCoordinate mc);
    public void removeWall(MazeCoordinate mc, int directionIndex);
    public void removeWall(Border border);
    public MazeCoordinate move(MazeCoordinate mc, int directionIndex);
    public boolean inside(MazeCoordinate mc);
    public int getValue(MazeCoordinate mc);
    public MazeCoordinate getStart();
    public MazeCoordinate getFinish();
}
