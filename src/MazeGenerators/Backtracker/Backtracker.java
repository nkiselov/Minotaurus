package MazeGenerators.Backtracker;

import MazeCoordinates.MazeCoordinate;
import Mazes.Maze;

import java.util.Stack;

public class Backtracker {

    public static void generateMaze(BacktrackerOptions bp, Maze maze){
        Stack<MazeCoordinate> visited = new Stack<>();
        int[] directions = maze.getDirections();
        int[] opposites = maze.getOpposites();
        int[] indeces = new int[directions.length];
        for (int i=0; i<indeces.length; i++){
            indeces[i]=i;
        }
        MazeCoordinate cp = bp.start;
        main:
        while(true) {
            shuffle(indeces);
            for (int i : indeces) {
                MazeCoordinate np = maze.move(cp,i);
                if (maze.inside(np)) {
                    if(maze.getValue(np)==0) {
                        maze.removeWall(cp,directions[i]);
                        maze.removeWall(np,opposites[i]);
                        visited.push(cp);
                        cp = np;
                        continue main;
                    }
                }
            }
            if (visited.size() != 0) {
                cp = visited.pop();
            }else{
                break;
            }
        }
        for(int i=0; i<directions.length; i++){
            if(!maze.inside(maze.move(maze.getStart(),i))){
                maze.removeWall(maze.getStart(),directions[i]);
            }
            if(!maze.inside(maze.move(maze.getFinish(),i))){
                maze.removeWall(maze.getFinish(),directions[i]);
            }
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
