import MazeGenerators.Kruskal.KruskalOptions;
import MazeGenerators.Prim.PrimOptions;
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
        Maze maze = MazeGenerator.generateMaze(new BacktrackerOptions(new SquareCoordinate((int)(15*hardness/2),0)), new SquareMazeOptions((int)(15*hardness),(int)(20*hardness)));
        //Kruskal
        //Maze maze = MazeGenerator.generateMaze(new KruskalOptions(), new SquareMazeOptions((int)(15*hardness),(int)(20*hardness)));
        //Prim
        //Maze maze = MazeGenerator.generateMaze(new PrimOptions(new SquareCoordinate(0,0)), new SquareMazeOptions((int)(15*hardness),(int)(20*hardness)));
        MazeRenderer.saveMaze(maze, new SquareMazeRendererOptions(10),new File("image.png"),"png");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
