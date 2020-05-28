package MazeRenderers.SquareMazeRenderer;

import MazeUtilities.MazeImage;
import MazeUtilities.MazePath;
import MazeUtilities.Square.SquareCoordinate;
import MazeUtilities.Square.SquareDirection;
import Mazes.MazeType;
import Mazes.SquareMaze.SquareMaze;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SquareMazeRenderer {
    public static MazeImage renderMaze(SquareMaze maze, SquareMazeRendererOptions options){
        int pixelsPerSquare = options.pixelsPerSquare;
        BufferedImage bufferedImage =
                new BufferedImage(pixelsPerSquare*maze.width + 2*options.margin, pixelsPerSquare*maze.height + 2*options.margin,
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
                        int ox = x * pixelsPerSquare + options.margin;
                        int oy = y * pixelsPerSquare + options.margin;
                        gc.drawLine(ox + Math.max(dx, 0), oy + Math.max(dy, 0), ox + Math.max(dx, 0) + Math.abs(dy), oy + Math.max(dy, 0) + Math.abs(dx));
                    }
                }
            }
        }
        return new MazeImage(bufferedImage,MazeType.SQUARE,options,maze);
    }

    public static MazeImage drawOverlayPath(MazeImage mazeImage, MazePath path, Color color){
        Graphics2D gc = mazeImage.mazeBufferedImage.createGraphics();
        gc.setStroke(new BasicStroke(1));
        gc.setPaint(color);
        int pixelsPerSquare = ((SquareMazeRendererOptions)mazeImage.options).pixelsPerSquare;
        int margin = ((SquareMazeRendererOptions) mazeImage.options).margin;
        for(int i=0; i<path.path.size()-1; i++){
            SquareCoordinate start = (SquareCoordinate)path.path.get(i);
            SquareCoordinate end= (SquareCoordinate)path.path.get(i+1);
            gc.drawLine(start.x*pixelsPerSquare+pixelsPerSquare/2+margin,start.y*pixelsPerSquare+pixelsPerSquare/2+margin,end.x*pixelsPerSquare+pixelsPerSquare/2+margin,end.y*pixelsPerSquare+pixelsPerSquare/2+margin);
        }
        return mazeImage;
    }
}
