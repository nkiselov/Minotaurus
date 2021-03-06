package Mazes.SquareMaze;

import MazeUtilities.Square.SquareCoordinate;
import Mazes.MazeOptions;
import Mazes.MazeType;

public class SquareMazeOptions implements MazeOptions {
    public int width;
    public int height;
    public SquareCoordinate start;
    public SquareCoordinate finish;

    public SquareMazeOptions(int width, int height, SquareCoordinate start, SquareCoordinate finish) {
        this.width = width;
        this.height = height;
        this.start = start;
        this.finish = finish;
    }

    public SquareMazeOptions(int width, int height) {
        this.width = width;
        this.height = height;
        start = new SquareCoordinate(0,0);
        finish = new SquareCoordinate(width-1,height-1);
    }

    @Override
    public MazeType getMazeType() {
        return MazeType.SQUARE;
    }
}
