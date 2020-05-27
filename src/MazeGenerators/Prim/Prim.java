package MazeGenerators.Prim;

import MazeUtilities.MazeCoordinate;
import MazeUtilities.MazeDirection;
import Mazes.Maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prim {
    public static void generateMaze(PrimOptions pp, Maze maze) {
        List<MazeCoordinate> frontier = new ArrayList<>();
        List<MazeCoordinate> visited = new ArrayList<>();
        frontier.add(pp.start);
        while(frontier.size()>0){
            MazeCoordinate base = frontier.get((int)(Math.random()*frontier.size()));
            boolean connected=false;
            List<MazeDirection> possibleDirections = maze.getPossibleDirections(base);
            Collections.shuffle(possibleDirections);
            for(MazeDirection dir : possibleDirections){
                MazeCoordinate newCoordinate = maze.move(base,dir);
                if(maze.inside(newCoordinate)) {
                    if (visited.contains(newCoordinate)) {
                        if (!connected) {
                            maze.removeWall(base, dir);
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
        MazeCoordinate start = maze.getStart();
        for(MazeDirection dir : maze.getPossibleDirections(start)){
            if(!maze.inside(maze.move(maze.getStart(),dir))){
                maze.removeWall(start,dir);
            }
        }
        MazeCoordinate finish = maze.getFinish();
        for(MazeDirection dir : maze.getPossibleDirections(finish)){
            if(!maze.inside(maze.move(maze.getFinish(),dir))){
                maze.removeWall(finish,dir);
            }
        }
    }
}
