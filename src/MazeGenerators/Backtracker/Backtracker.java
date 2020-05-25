package MazeGenerators.Backtracker;

import MazeGenerators.GeneratorOptions;
import Mazes.Maze;
import Mazes.MazeType;

public class Backtracker {
    public static Maze generateMaz(MazeType mazeType, GeneratorOptions generatorOptions){
        switch (mazeType){
            case SQUARE:
                SquareBacktracker sb = new SquareBacktracker();
                return sb.generateMaze((SquareBacktrackerOptions)generatorOptions);
            default:
                return null;
        }
    }
}
