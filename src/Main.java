import MazeGenerators.Backtracker.Backtracker;
import MazeGenerators.Kruskal.KruskalOptions;
import MazeGenerators.Prim.PrimOptions;
import MazeSolvers.AStar;
import MazeUtilities.MazeImage;
import MazeUtilities.MazePath;
import MazeUtilities.SquareCoordinate;
import MazeGenerators.Backtracker.BacktrackerOptions;
import MazeGenerators.MazeGenerator;
import MazeRenderers.MazeRenderer;
import MazeRenderers.SquareMazeRenderer.SquareMazeRendererOptions;
import Mazes.Maze;
import Mazes.SquareMaze.SquareMazeOptions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        double hardness = 3;

        //Backtracker
        //Maze maze = MazeGenerator.generateMaze(new BacktrackerOptions(new SquareCoordinate((int)(15*hardness/2),0)), new SquareMazeOptions((int)(15*hardness),(int)(20*hardness)));
        //Kruskal
        //Maze maze = MazeGenerator.generateMaze(new KruskalOptions(), new SquareMazeOptions((int)(15*hardness),(int)(20*hardness)));
        //Prim
        //Maze maze = MazeGenerator.generateMaze(new PrimOptions(new SquareCoordinate(0,0)), new SquareMazeOptions((int)(15*hardness),(int)(20*hardness)));
        //Render
        //MazeRenderer.saveMaze(maze, new SquareMazeRendererOptions(10),new File("squareBacktrackerMaze.png"),"png");

        //Create 50x50 maze using backtracker starting at (10,10)
        Maze maze = MazeGenerator.generateMaze(new BacktrackerOptions(new SquareCoordinate(10,10)), new SquareMazeOptions(50,50));
        //Render maze
        MazeImage mazeImage = MazeRenderer.renderMaze(maze, new SquareMazeRendererOptions(10,1));
        //Save maze image without solution
        MazeRenderer.saveMazeImage(mazeImage,new File("squareKruskalMaze.png"),"png");
        //Generate solution using AStar
        MazePath solution = AStar.solve(maze);
        //Draw solution overlay red
        MazeRenderer.drawOverlayPath(mazeImage,solution, Color.blue);
        //Save maze image with solution
        MazeRenderer.saveMazeImage(mazeImage,new File("squareKruskalMazeSolution.png"),"png");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
