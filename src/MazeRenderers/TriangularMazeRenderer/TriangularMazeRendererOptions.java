package MazeRenderers.TriangularMazeRenderer;

import MazeRenderers.MazeRendererOptions;

public class TriangularMazeRendererOptions implements MazeRendererOptions {
    public int pixelsPerTriangle;
    public int margin;

    public TriangularMazeRendererOptions(int pixelsPerTriangle, int margin) {
        this.pixelsPerTriangle = pixelsPerTriangle;
        this.margin = margin;
    }
}
