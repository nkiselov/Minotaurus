package Mazes.SquareMaze;

import MazeCoordinates.Border;
import MazeCoordinates.MazeCoordinate;
import MazeCoordinates.SquareCoordinate;
import Mazes.Maze;
import Mazes.MazeOptions;
import Mazes.MazeType;

import java.util.ArrayList;
import java.util.List;

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
    public List<Border> getAllBorders() {
        List<Border> borders = new ArrayList<>();
        for(int x=0; x<width; x++){
            for(int y=0; y<height; y++){
                if(y<height-1) {
                    borders.add(new Border(new SquareCoordinate(x, y), new SquareCoordinate(x, y + 1)));
                }
                if(x<width-1){
                    borders.add(new Border(new SquareCoordinate(x, y), new SquareCoordinate(x+1, y)));
                }
            }
        }
        return borders;
    }

    @Override
    public int getTotalCells() {
        return width*height;
    }

    @Override
    public int uniqueId(MazeCoordinate mc) {
        SquareCoordinate sc = (SquareCoordinate)mc;
        return sc.x*height+sc.y;
    }

    @Override
    public void removeWall(MazeCoordinate mc, int direction) {
        SquareCoordinate sc = (SquareCoordinate)mc;
        grid[sc.x][sc.y] |= direction;
    }

    @Override
    public void removeWall(Border border) {
        int dx = ((SquareCoordinate)border.c2).x-((SquareCoordinate)border.c1).x;
        int dy = ((SquareCoordinate)border.c2).y-((SquareCoordinate)border.c1).y;
        int ind = 2+dy-2*Math.max(dx,0);
        removeWall(border.c1,directions[ind]);
        removeWall(border.c2,opposites[ind]);
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
