package MazeUtilities;

import MazeRenderers.MazeRendererOptions;
import Mazes.Maze;
import Mazes.MazeType;

import java.awt.image.BufferedImage;

public class MazeImage {
    public BufferedImage mazeBufferedImage;
    public MazeType mazeType;
    public MazeRendererOptions options;
    public Maze maze;

    public MazeImage(BufferedImage mazeBufferedImage, MazeType mazeType, MazeRendererOptions options, Maze maze) {
        this.mazeBufferedImage = mazeBufferedImage;
        this.mazeType = mazeType;
        this.options = options;
        this.maze = maze;
    }
}
