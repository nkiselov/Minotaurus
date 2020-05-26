package MazeGenerators;

import MazeGenerators.Backtracker.*;
import MazeGenerators.Kruskal.*;
import MazeGenerators.Prim.*;
import Mazes.Maze;
import Mazes.MazeOptions;
import Mazes.SquareMaze.SquareMaze;

public class MazeGenerator {
    public static Maze generateMaze(GeneratorOptions generatorOptions, MazeOptions mazeOptions){
        Maze maze;
        switch (mazeOptions.getMazeType()){
            case SQUARE:
                maze=new SquareMaze();
                break;
            default:
                return null;
        }
        maze.initialize(mazeOptions);
        switch (generatorOptions.getGeneratorType()){
            case BACKTRACKER:
                Backtracker.generateMaze((BacktrackerOptions)generatorOptions,maze);
                break;
            case KRUSKAL:
                Kruskal.generateMaze((KruskalOptions)generatorOptions,maze);
                break;
            case PRIM:
                Prim.generateMaze((PrimOptions)generatorOptions,maze);
                break;
            default:
                return null;
        }
        return maze;
    }
}
