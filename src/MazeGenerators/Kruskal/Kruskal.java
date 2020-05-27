package MazeGenerators.Kruskal;

import MazeUtilities.Border;
import MazeUtilities.MazeCoordinate;
import MazeUtilities.MazeDirection;
import Mazes.Maze;

import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static void generateMaze(KruskalOptions kp, Maze maze) {
        List<Border> borders = maze.getAllBorders();
        Collections.shuffle(borders);
        int[] cellIds = new int[maze.getTotalCells()];
        for(int i=0; i<cellIds.length; i++){
            cellIds[i]=i;
        }
        int remainingIds = cellIds.length;

        for(int i=0; i<borders.size(); i++){
            if(remainingIds==1){
                break;
            }
            int id1 = cellIds[maze.uniqueId(borders.get(i).c1)];
            int id2 = cellIds[maze.uniqueId(borders.get(i).c2)];
            if(id1!=id2){
                maze.removeWall(borders.get(i));
                for (int a=0; a<cellIds.length; a++){
                    if(cellIds[a]==id2){
                        cellIds[a]=id1;
                    }
                }
                remainingIds--;
            }
        }
        MazeCoordinate start = maze.getStart();
        for(MazeDirection dir : maze.getPossibleDirections(start)){
            if(!maze.inside(maze.move(maze.getStart(),dir))){
                maze.removeWall(start,dir);
            }
        }
        MazeCoordinate finish = maze.getStart();
        for(MazeDirection dir : maze.getPossibleDirections(finish)){
            if(!maze.inside(maze.move(maze.getStart(),dir))){
                maze.removeWall(finish,dir);
            }
        }
    }
}
