package MazeSolvers;

import MazeUtilities.MazeCoordinate;
import MazeUtilities.MazeDirection;
import MazeUtilities.MazePath;
import Mazes.Maze;

import java.util.ArrayList;
import java.util.List;

public class AStar {
    public static MazePath solve(Maze maze){
        List<AStarNode> open = new ArrayList<>();
        List<AStarNode> closed = new ArrayList<>();
        open.add(new AStarNode(maze.getStart(),0,maze.distance(maze.getStart(),maze.getFinish()),null));
        AStarNode current;
        while(true){
            current = getLowestCostNode(open);
            closed.add(current);
            open.remove(current);
            if(current.coordinate.equals(maze.getFinish())){
                break;
            }
            for(MazeDirection dir : maze.getMovableDirections(current.coordinate)){
                MazeCoordinate newCoordinate = maze.move(current.coordinate,dir);
                AStarNode neighbor = new AStarNode(newCoordinate,maze.distance(newCoordinate,current.coordinate)+current.startValue,maze.distance(newCoordinate,maze.getFinish()),current);
                if(closed.contains(neighbor)){
                    continue;
                }
                if(!open.contains(neighbor)){
                    open.add(neighbor);
                }else{
                    int existingIndex = open.indexOf(neighbor);
                    if(open.get(existingIndex).getTotal()>neighbor.getTotal()){
                        open.set(existingIndex,neighbor);
                    }
                }
            }
        }
        List<MazeCoordinate> path = new ArrayList<>();
        while(true){
            path.add(current.coordinate);
            if(current.parent != null){
                current=current.parent;
            }else{
                break;
            }
        }
        return new MazePath(path);
    }

    private static AStarNode getLowestCostNode(List<AStarNode> nodes){
        double lowestCost = nodes.get(0).getTotal();
        AStarNode lowestCostNode = nodes.get(0);
        for(int i=1; i<nodes.size(); i++){
            AStarNode node = nodes.get(i);
            if(node.getTotal()<lowestCost){
                lowestCost = node.getTotal();
                lowestCostNode=node;
            }
        }
        return lowestCostNode;
    }

    private static AStarNode findByCoordinate(List<AStarNode> nodes, MazeCoordinate mc){
        for(AStarNode node: nodes){
            if(node.coordinate.equals(mc)){
                return node;
            }
        }
        return null;
    }
}
