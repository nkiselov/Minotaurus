package MazeGenerators.Prim;

import MazeCoordinates.MazeCoordinate;
import Mazes.Maze;

import java.util.ArrayList;
import java.util.List;

public class Prim {
    public static void generateMaze(PrimOptions pp, Maze maze) {
        List<MazeCoordinate> frontier = new ArrayList<>();
        List<MazeCoordinate> visited = new ArrayList<>();
        int[] directions = maze.getDirections();
        int[] opposites = maze.getOpposites();
        frontier.add(pp.start);
        while(frontier.size()>0){
            MazeCoordinate base = frontier.get((int)(Math.random()*frontier.size()));
            boolean connected=false;
            for(int i=0; i<directions.length; i++){
                MazeCoordinate newCoordinate = maze.move(base,i);
                if(maze.inside(newCoordinate)) {
                    if (visited.contains(newCoordinate)) {
                        if (!connected) {
                            maze.removeWall(base, directions[i]);
                            maze.removeWall(newCoordinate, opposites[i]);
                            connected = true;
                        }
                    } else {
                        if(!frontier.contains(newCoordinate)) {
                            frontier.add(newCoordinate);
                        }
                    }
                }
            }
            frontier.remove(base);
            visited.add(base);
        }
    }

    static void shuffle(int[] array){
        for(int j=0; j<array.length; j++){
            for(int i=0; i<array.length-1; i++){
                if(Math.random()>0.5){
                    int temp = array[i+1];
                    array[i+1] =  array[i];
                    array[i]=temp;
                }
            }
        }
    }
}
