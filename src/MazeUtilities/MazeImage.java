package MazeUtilities;

import MazeRenderers.MazeRendererOptions;
import Mazes.MazeType;

import java.awt.image.BufferedImage;

public class MazeImage {
    public BufferedImage mazeBufferedImage;
    public MazeType mazeType;
    public MazeRendererOptions options;

    public MazeImage(BufferedImage mazeBufferedImage, MazeType mazeType, MazeRendererOptions options) {
        this.mazeBufferedImage = mazeBufferedImage;
        this.mazeType = mazeType;
        this.options = options;
    }
}
