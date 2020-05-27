package MazeRenderers;

import MazeRenderers.SquareMazeRenderer.SquareMazeRenderer;
import MazeRenderers.SquareMazeRenderer.SquareMazeRendererOptions;
import MazeUtilities.MazeImage;
import MazeUtilities.MazePath;
import Mazes.Maze;
import Mazes.MazeType;
import Mazes.SquareMaze.SquareMaze;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MazeRenderer {
    public static MazeImage renderMaze(Maze maze, MazeRendererOptions mazeRendererOptions){
        switch(maze.getMazeType()){
            case SQUARE:
                return SquareMazeRenderer.renderMaze((SquareMaze)maze,(SquareMazeRendererOptions)mazeRendererOptions);
            default:
                return null;
        }
    }

    public static MazeImage drawOverlayPath(MazeImage mazeImage, MazePath path, Color color){
        switch(mazeImage.mazeType){
            case SQUARE:
                return SquareMazeRenderer.drawOverlayPath(mazeImage,path,color);
            default:
                return null;
        }
    }

    public static void saveMaze(Maze maze, MazeRendererOptions mazeRendererOptions, File outputFile, String extension) throws IOException{
        ImageIO.write(Objects.requireNonNull(renderMaze(maze, mazeRendererOptions)).mazeBufferedImage, extension, outputFile);
    }

    public static void saveMazeImage(MazeImage mazeImage, File outputFile, String extension) throws IOException{
        ImageIO.write(mazeImage.mazeBufferedImage, extension, outputFile);
    }
}
