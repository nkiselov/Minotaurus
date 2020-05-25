import MazeGenerators.Backtracker.SquareBacktracker;
import MazeGenerators.Backtracker.SquareBacktrackerOptions;
import MazeGenerators.GeneratorType;
import MazeGenerators.MazeGenerator;
import MazeRenderers.MazeRenderer;
import MazeRenderers.SquareMazeRendererOptions;
import Mazes.Maze;
import Mazes.MazeType;
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
        int hardness = 5;
        Maze maze =  MazeGenerator.generateMaze(GeneratorType.BACKTRACKER, MazeType.SQUARE,new SquareBacktrackerOptions(15*hardness,20*hardness));
        MazeRenderer.saveMaze(maze, new SquareMazeRendererOptions(10),new File("image.png"),"png");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
