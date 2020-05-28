package MazeRenderers;

import MazeRenderers.SquareMazeRenderer.SquareMazeRenderer;
import MazeRenderers.SquareMazeRenderer.SquareMazeRendererOptions;
import MazeRenderers.TriangularMazeRenderer.TriangularMazeRenderer;
import MazeRenderers.TriangularMazeRenderer.TriangularMazeRendererOptions;
import MazeUtilities.MazeImage;
import MazeUtilities.MazePath;
import Mazes.Maze;
import Mazes.SquareMaze.SquareMaze;
import Mazes.TriangularMaze.TriangularMaze;

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
            case TRIANGULAR:
                return TriangularMazeRenderer.renderMaze((TriangularMaze)maze,(TriangularMazeRendererOptions)mazeRendererOptions);
            default:
                return null;
        }
    }

    public static MazeImage drawOverlayPath(MazeImage mazeImage, MazePath path, Color color){
        switch(mazeImage.mazeType){
            case SQUARE:
                return SquareMazeRenderer.drawOverlayPath(mazeImage,path,color);
            case TRIANGULAR:
                return TriangularMazeRenderer.drawOverlayPath(mazeImage,path,color);
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
