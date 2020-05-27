package MazeRenderers.SquareMazeRenderer;

import MazeUtilities.SquareDirection;
import Mazes.SquareMaze.SquareMaze;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SquareMazeRenderer {
    public static BufferedImage renderMaze(SquareMaze maze,SquareMazeRendererOptions options){
        int pixelsPerSquare = options.pixelsPerSquare;
        BufferedImage bufferedImage =
                new BufferedImage(pixelsPerSquare*maze.width+2, pixelsPerSquare*maze.height+2,
                        BufferedImage.TYPE_INT_ARGB);

        Graphics2D gc = bufferedImage.createGraphics();
        gc.setBackground(Color.WHITE);
        gc.setStroke(new BasicStroke(1));
        gc.setPaint(Color.BLACK);
        for(int x=0; x<maze.width; x++) {
            for (int y = 0; y < maze.height; y++) {
                for (int i = 0; i < 4; i++) {
                    if ((maze.grid[x][y] | SquareDirection.directions[i]) != maze.grid[x][y]) {
                        int dx = SquareDirection.dxi[i] * pixelsPerSquare;
                        int dy = SquareDirection.dyi[i] * pixelsPerSquare;
                        int ox = x * pixelsPerSquare + 1;
                        int oy = y * pixelsPerSquare + 1;
                        gc.drawLine(ox + Math.max(dx, 0), oy + Math.max(dy, 0), ox + Math.max(dx, 0) + Math.abs(dy), oy + Math.max(dy, 0) + Math.abs(dx));
                    }
                }
            }
        }
        return bufferedImage;
    }
}
