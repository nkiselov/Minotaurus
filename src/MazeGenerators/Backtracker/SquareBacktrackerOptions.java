package MazeGenerators.Backtracker;

import MazeGenerators.GeneratorOptions;

public class SquareBacktrackerOptions implements GeneratorOptions {
    public int width;
    public int height;
    public int startX;
    public int startY;
    public int finishX;
    public int finishY;

    public SquareBacktrackerOptions(int width, int height) {
        this.width = width;
        this.height = height;
        startX = 0;
        startY = 0;
        finishX = width-1;
        finishY = height-1;
    }

    public SquareBacktrackerOptions(int width, int height, int startX, int startY, int finishX, int finishY) {
        this.width = width;
        this.height = height;
        this.startX = startX;
        this.startY = startY;
        this.finishX = finishX;
        this.finishY = finishY;
    }
}
