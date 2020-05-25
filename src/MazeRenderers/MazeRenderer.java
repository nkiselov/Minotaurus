package MazeRenderers;

import Mazes.Maze;
import Mazes.SquareMaze;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MazeRenderer {
    public static BufferedImage renderMaze(Maze maze, MazeRendererOptions mazeRendererOptions){
        switch(maze.getMazeType()){
            case SQUARE:
                return SquareMazeRenderer.renderMaze((SquareMaze)maze,(SquareMazeRendererOptions)mazeRendererOptions);
            default:
                return null;
        }
    }

    public static void saveMaze(Maze maze, MazeRendererOptions mazeRendererOptions, File outputFile, String extension) throws IOException{
        ImageIO.write(Objects.requireNonNull(renderMaze(maze, mazeRendererOptions)), extension, outputFile);
    }
}
