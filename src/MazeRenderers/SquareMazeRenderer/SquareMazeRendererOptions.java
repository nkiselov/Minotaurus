package MazeRenderers.SquareMazeRenderer;

import MazeRenderers.MazeRendererOptions;

public class SquareMazeRendererOptions implements MazeRendererOptions {
    public int pixelsPerSquare;
    public int margin;

    public SquareMazeRendererOptions(int pixelsPerSquare, int margin) {
        this.pixelsPerSquare = pixelsPerSquare;
        this.margin = margin;
    }
}
