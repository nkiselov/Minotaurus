package Mazes;

import MazeUtilities.MazeBorder;
import MazeUtilities.MazeCoordinate;
import MazeUtilities.MazeDirection;

import java.util.List;

public interface Maze {
    public MazeType getMazeType();
    //Generator
    public void initialize(MazeOptions mazeOptions);
    public List<MazeBorder> getAllBorders();
    public int getTotalCells();
    public int uniqueId(MazeCoordinate mc);
    public void removeWall(MazeCoordinate mc, MazeDirection direction);
    public void removeWall(MazeBorder border);
    public MazeCoordinate move(MazeCoordinate mc, MazeDirection direction);
    public List<MazeDirection> getPossibleDirections(MazeCoordinate mc);
    public boolean inside(MazeCoordinate mc);
    public boolean getIsolated(MazeCoordinate mc);
    public MazeCoordinate getStart();
    public MazeCoordinate getFinish();
    //Solver
    public List<MazeDirection> getMovableDirections(MazeCoordinate mc);
    public double distance(MazeCoordinate c1,MazeCoordinate c2);
}
