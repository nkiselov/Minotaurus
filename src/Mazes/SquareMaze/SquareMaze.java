package Mazes.SquareMaze;

import MazeUtilities.*;
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
    public void removeWall(MazeCoordinate mc, MazeDirection direction) {
        SquareCoordinate sc = (SquareCoordinate)mc;
        SquareDirection sd = (SquareDirection)direction;
        SquareCoordinate scn = (SquareCoordinate) move(mc,direction);
        grid[sc.x][sc.y] |= sd.getValue();
        if(inside(scn)) {
            grid[scn.x][scn.y] |= sd.getOppositeValue();
        }
    }

    @Override
    public void removeWall(Border border) {
        int dx = ((SquareCoordinate)border.c2).x-((SquareCoordinate)border.c1).x;
        int dy = ((SquareCoordinate)border.c2).y-((SquareCoordinate)border.c1).y;
        removeWall(border.c1,new SquareDirection(dx,dy));
    }

    @Override
    public MazeCoordinate move(MazeCoordinate mc, MazeDirection direction) {
        SquareCoordinate sc = (SquareCoordinate)mc;
        SquareDirection sd = (SquareDirection)direction;
        return new SquareCoordinate(sc.x+sd.dx,sc.y+sd.dy);
    }

    @Override
    public List<MazeDirection> getPossibleDirections(MazeCoordinate mc) {
        List<MazeDirection> possibleDirections = new ArrayList<>();
        for(int i =0 ; i<4; i++){
            possibleDirections.add(new SquareDirection(i));
        }
        return possibleDirections;
    }

    @Override
    public boolean inside(MazeCoordinate mc) {
        SquareCoordinate sc = (SquareCoordinate)mc;
        return sc.x>=0 && sc.x<width && sc.y>=0 && sc.y<height;
    }

    @Override
    public boolean getIsolated(MazeCoordinate mc) {
        SquareCoordinate sc = (SquareCoordinate)mc;
        return grid[sc.x][sc.y]==0;
    }

    @Override
    public MazeCoordinate getStart() {
        return start;
    }

    @Override
    public MazeCoordinate getFinish() {
        return finish;
    }

    @Override
    public List<MazeDirection> getMovableDirections(MazeCoordinate mc) {
        List<MazeDirection> movableDirections = new ArrayList<>();
        SquareCoordinate sc = (SquareCoordinate)mc;
        for(int i = 0 ; i<4; i++) {
            if((grid[sc.x][sc.y]|SquareDirection.directions[i])==grid[sc.x][sc.y]){
                MazeDirection dir = new SquareDirection(i);
                if(inside(move(sc,dir))) {
                    movableDirections.add(dir);
                }
            }
        }
        return movableDirections;
    }

    @Override
    public double distance(MazeCoordinate c1, MazeCoordinate c2) {
        int dx = ((SquareCoordinate)c2).x-((SquareCoordinate)c1).x;
        int dy = ((SquareCoordinate)c2).y-((SquareCoordinate)c1).y;
        return Math.sqrt(dx*dx+dy*dy);
    }
}
