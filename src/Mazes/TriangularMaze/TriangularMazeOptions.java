package Mazes.TriangularMaze;

import MazeUtilities.Triangular.TriangularCoordinate;
import Mazes.MazeOptions;
import Mazes.MazeType;

public class TriangularMazeOptions implements MazeOptions {
    public int sideLength;
    public TriangularCoordinate start;
    public TriangularCoordinate finish;

    @Override
    public MazeType getMazeType() {
        return MazeType.TRIANGULAR;
    }

    public TriangularMazeOptions(int sideLength) {
        this.sideLength = sideLength;
        this.start = new TriangularCoordinate(sideLength-1,0,false);
        this.finish = new TriangularCoordinate(0,sideLength-1,false);
    }

    public TriangularMazeOptions(int sideLength, TriangularCoordinate start, TriangularCoordinate finish) {
        this.sideLength = sideLength;
        this.start = start;
        this.finish = finish;
    }
}
