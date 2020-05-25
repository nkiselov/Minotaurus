package MazeRenderers.SquareMazeRenderer;

import MazeRenderers.MazeRendererOptions;

public class SquareMazeRendererOptions implements MazeRendererOptions {
    public int pixelsPerSquare;

    public SquareMazeRendererOptions(int pixelsPerSquare) {
        this.pixelsPerSquare = pixelsPerSquare;
    }
}
