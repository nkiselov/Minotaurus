package MazeRenderers.TriangularMazeRenderer;

import MazeRenderers.SquareMazeRenderer.SquareMazeRendererOptions;
import MazeUtilities.MazeImage;
import MazeUtilities.MazePath;
import MazeUtilities.Triangular.TriangularCoordinate;
import Mazes.MazeType;
import Mazes.SquareMaze.SquareMaze;
import Mazes.TriangularMaze.TriangularMaze;
import Mazes.TriangularMaze.TriangularMazeOptions;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TriangularMazeRenderer {
    private static double triangleTop = Math.sqrt(3)/2;
    public static MazeImage renderMaze(TriangularMaze maze, TriangularMazeRendererOptions options){
        int pixelsPerTriangle = options.pixelsPerTriangle;
        BufferedImage bufferedImage =
                new BufferedImage(pixelsPerTriangle*maze.sideLength + 2*options.margin, pixelsPerTriangle*maze.sideLength + 2*options.margin,
                        BufferedImage.TYPE_INT_ARGB);

        Graphics2D gc = bufferedImage.createGraphics();
        gc.setBackground(Color.WHITE);
        gc.setStroke(new BasicStroke(1));
        gc.setPaint(Color.BLACK);
        int yMargin = (int)((1-triangleTop)*maze.sideLength*pixelsPerTriangle/2)+options.margin;
        for(int x=0; x<maze.sideLength; x++){
            for(int y=0; y<maze.sideLength-x; y++){
                int value = maze.grid[x][y][0];
                double baseY = bufferedImage.getHeight()-yMargin-y*triangleTop*pixelsPerTriangle;
                int baseX = options.margin+pixelsPerTriangle*x+y*pixelsPerTriangle/2;
                if((value|1)!=value){
                    gc.drawLine(baseX+pixelsPerTriangle/2, (int) (baseY-triangleTop*pixelsPerTriangle),baseX+pixelsPerTriangle,(int)baseY);
                }
                if((value|4)!=value){
                    gc.drawLine(baseX,(int)baseY,baseX+pixelsPerTriangle/2,(int) (baseY-triangleTop*pixelsPerTriangle));
                }
                if((value|2)!=value){
                    gc.drawLine(baseX,(int)baseY,baseX+pixelsPerTriangle,(int)baseY);
                }
            }
        }
        return new MazeImage(bufferedImage, MazeType.TRIANGULAR,options,maze);
    }

    public static MazeImage drawOverlayPath(MazeImage mazeImage, MazePath path, Color color) {
        TriangularMazeRendererOptions options = ((TriangularMazeRendererOptions)mazeImage.options);
        int pixelsPerTriangle = options.pixelsPerTriangle;
        int sideLength = ((TriangularMaze)mazeImage.maze).sideLength;
        int yMargin = (int)((1-triangleTop)*sideLength*pixelsPerTriangle/2)+options.margin;
        int height = mazeImage.mazeBufferedImage.getHeight();
        Graphics2D gc = mazeImage.mazeBufferedImage.createGraphics();
        gc.setStroke(new BasicStroke(1));
        gc.setPaint(color);
        int prevX=0;
        int prevY=0;
        boolean start=false;
        for(int i=0; i<path.path.size()-1; i++) {
            TriangularCoordinate tc = (TriangularCoordinate) path.path.get(i);
            int newX = options.margin+pixelsPerTriangle*tc.x+(tc.y+1)*pixelsPerTriangle/2;
            double newY = height-yMargin-tc.y*triangleTop*pixelsPerTriangle;
            if(tc.z){
                newX+=pixelsPerTriangle/2;
                newY-= 2*triangleTop*pixelsPerTriangle/3;
            }else{
                newY-= triangleTop*pixelsPerTriangle/3;
            }
            if(start){
                gc.drawLine(prevX,prevY,newX,(int)newY);
            }else{
                start=true;
            }
            prevX=newX;
            prevY=(int)newY;
        }
        return mazeImage;
    }
}
