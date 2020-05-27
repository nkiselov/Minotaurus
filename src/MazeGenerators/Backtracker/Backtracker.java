package MazeGenerators.Backtracker;

import MazeUtilities.MazeCoordinate;
import MazeUtilities.MazeDirection;
import Mazes.Maze;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Backtracker {

    public static void generateMaze(BacktrackerOptions bp, Maze maze){
        Stack<MazeCoordinate> visited = new Stack<>();
        MazeCoordinate cp = bp.start;
        main:
        while(true) {
            List<MazeDirection> possibleDirections = maze.getPossibleDirections(cp);
            Collections.shuffle(possibleDirections);
            for (MazeDirection dir : possibleDirections) {
                MazeCoordinate np = maze.move(cp,dir);
                if (maze.inside(np)) {
                    if(maze.getIsolated(np)) {
                        maze.removeWall(cp,dir);
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
