package Mazes.SquareMaze;

import MazeCoordinates.MazeCoordinate;
import MazeCoordinates.SquareCoordinate;
import Mazes.Maze;
import Mazes.MazeOptions;
import Mazes.MazeType;

public class SquareMaze implements Maze {
    public int[][] grid;
    public int width;
    public int height;
    public SquareCoordinate start;
    public SquareCoordinate finish;

    public static int[] directions = {1, 2, 4, 8};
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int[] opposites = {4, 8, 1, 2};

    @Override
    public MazeType getMazeType() {
        return MazeType.SQUARE;
    }

    @Override
    public void initialize(MazeOptions mazeOptions) {
        SquareMazeOptions squareMazeOptions = (SquareMazeOptions)mazeOptions;
        width = squareMazeOptions.width;
        height = squareMazeOptions.height;
        grid = new int[width][height];
        start = squareMazeOptions.start;
        finish = squareMazeOptions.finish;
    }

    @Override
    public int[] getDirections() {
        return directions;
    }

    @Override
    public int[] getOpposites() {
        return opposites;
    }

    @Override
    public void removeWall(MazeCoordinate mc, int direction) {
        SquareCoordinate sc = (SquareCoordinate)mc;
        grid[sc.x][sc.y] |= direction;
    }

    @Override
    public MazeCoordinate move(MazeCoordinate mc, int directionIndex) {
        SquareCoordinate sc = (SquareCoordinate)mc;
        return new SquareCoordinate(sc.x+dx[directionIndex],sc.y+dy[directionIndex]);
    }

    @Override
    public boolean inside(MazeCoordinate mc) {
        SquareCoordinate sc = (SquareCoordinate)mc;
        return sc.x>=0 && sc.x<width && sc.y>=0 && sc.y<height;
    }

    @Override
    public int getValue(MazeCoordinate mc) {
        SquareCoordinate sc = (SquareCoordinate)mc;
        return grid[sc.x][sc.y];
    }

    @Override
    public MazeCoordinate getStart() {
        return start;
    }

    @Override
    public MazeCoordinate getFinish() {
        return finish;
    }
}
