package MazeGenerators;

import MazeGenerators.Backtracker.Backtracker;
import Mazes.Maze;
import Mazes.MazeType;

public class MazeGenerator {
    public static Maze generateMaze(GeneratorType generatorType, MazeType mazeType, GeneratorOptions generatorOptions){
        switch (generatorType){
            case BACKTRACKER:
                return Backtracker.generateMaz(mazeType,generatorOptions);
            default:
                return null;
        }
    }
}
