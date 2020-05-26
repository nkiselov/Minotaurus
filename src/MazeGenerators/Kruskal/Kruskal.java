package MazeGenerators.Kruskal;

import MazeCoordinates.Border;
import Mazes.Maze;

import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static void generateMaze(KruskalOptions bp, Maze maze) {
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
        int[] directions = maze.getDirections();
        for(int i=0; i<directions.length; i++){
            if(!maze.inside(maze.move(maze.getStart(),i))){
                maze.removeWall(maze.getStart(),directions[i]);
            }
            if(!maze.inside(maze.move(maze.getFinish(),i))){
                maze.removeWall(maze.getFinish(),directions[i]);
            }
        }
    }
}
