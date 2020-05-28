package Mazes.TriangularMaze;

import MazeUtilities.MazeBorder;
import MazeUtilities.MazeCoordinate;
import MazeUtilities.MazeDirection;
import MazeUtilities.Triangular.TriangularCoordinate;
import MazeUtilities.Triangular.TriangularDirection;
import Mazes.Maze;
import Mazes.MazeOptions;
import Mazes.MazeType;

import java.util.ArrayList;
import java.util.List;

public class TriangularMaze implements Maze{
    public int sideLength;
    public int[][][] grid;
    public TriangularCoordinate start;
    public TriangularCoordinate finish;

    @Override
    public MazeType getMazeType() {
        return MazeType.TRIANGULAR;
    }

    @Override
    public void initialize(MazeOptions mazeOptions) {
        TriangularMazeOptions triangularMazeOptions = (TriangularMazeOptions)mazeOptions;
        sideLength = triangularMazeOptions.sideLength;
        grid = new int[sideLength][][];
        for(int x=0; x<sideLength; x++){
            grid[x] = new int[sideLength-x][2];
        }
        this.start=triangularMazeOptions.start;
        this.finish=triangularMazeOptions.finish;
    }

    @Override
    public List<MazeBorder> getAllBorders() {
        List<MazeBorder> borders = new ArrayList<>();
        for(int x =0; x<sideLength-1; x++){
            for (int y=0; y<sideLength-1-x; y++){
                TriangularCoordinate cnt = new TriangularCoordinate(x,y,true);
                for(int i=0; i<3; i++){
                    TriangularDirection dir = new TriangularDirection(i,true);
                    borders.add(new MazeBorder(cnt,move(cnt,dir)));
                }
            }
        }
        return borders;
    }

    @Override
    public int getTotalCells() {
        return sideLength*sideLength;
    }

    @Override
    public int uniqueId(MazeCoordinate mc) {
        TriangularCoordinate tc = (TriangularCoordinate)mc;
        return 2*tc.x+2*sideLength*tc.y-tc.y*tc.y+(tc.z?1:0);
    }

    @Override
    public void removeWall(MazeCoordinate mc, MazeDirection direction) {
        TriangularCoordinate tc = (TriangularCoordinate)mc;
        TriangularDirection td = (TriangularDirection)direction;
        TriangularCoordinate tcn = (TriangularCoordinate) move(mc,direction);
        grid[tc.x][tc.y][tc.z?1:0] |= td.getValue();
        if(inside(tcn)) {
            grid[tcn.x][tcn.y][tcn.z?1:0] |= td.getValue();
        }
    }

    @Override
    public void removeWall(MazeBorder border) {
        int dx = ((TriangularCoordinate)border.c2).x-((TriangularCoordinate)border.c1).x;
        int dy = ((TriangularCoordinate)border.c2).y-((TriangularCoordinate)border.c1).y;
        removeWall(border.c1,new TriangularDirection(dx,dy));
    }

    @Override
    public MazeCoordinate move(MazeCoordinate mc, MazeDirection direction) {
        TriangularCoordinate tc = (TriangularCoordinate)mc;
        TriangularDirection td = (TriangularDirection)direction;
        return new TriangularCoordinate(tc.x+td.dx,tc.y+td.dy,!tc.z);
    }

    @Override
    public List<MazeDirection> getPossibleDirections(MazeCoordinate mc) {
        TriangularCoordinate tc = (TriangularCoordinate)mc;
        List<MazeDirection> possibleDirections = new ArrayList<>();
        for(int i =0 ; i<3; i++){
            possibleDirections.add(new TriangularDirection(i,tc.z));
        }
        return possibleDirections;
    }

    @Override
    public boolean inside(MazeCoordinate mc) {
        TriangularCoordinate tc = (TriangularCoordinate)mc;
        if(tc.x+tc.y==sideLength-1){
            return !tc.z;
        }else{
            return tc.x + tc.y < sideLength-1 && tc.x>=0 && tc.y>=0;
        }
    }

    @Override
    public boolean getIsolated(MazeCoordinate mc) {
        TriangularCoordinate tc = (TriangularCoordinate)mc;
        return grid[tc.x][tc.y][tc.z?1:0]==0;
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
        TriangularCoordinate tc = (TriangularCoordinate)mc;
        for(int i = 0 ; i<3; i++) {
            if((grid[tc.x][tc.y][tc.z?1:0]|TriangularDirection.directions[i])==grid[tc.x][tc.y][tc.z?1:0]){
                MazeDirection dir = new TriangularDirection(i,tc.z);
                if(inside(move(tc,dir))) {
                    movableDirections.add(dir);
                }
            }
        }
        return movableDirections;
    }

    @Override
    public double distance(MazeCoordinate c1, MazeCoordinate c2) {
        TriangularCoordinate t1 = (TriangularCoordinate)c1;
        TriangularCoordinate t2 = (TriangularCoordinate)c2;
        int dx = t2.x-t1.x+(t2.z?1:0)-(t1.z?1:0);
        int dy = t2.y-t1.y;
        return Math.sqrt(dx*dx+dy*dy);
    }
}
