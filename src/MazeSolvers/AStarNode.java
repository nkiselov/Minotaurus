package MazeSolvers;

import MazeUtilities.MazeCoordinate;

public class AStarNode{
    public MazeCoordinate coordinate;
    public double startValue;
    public double finishValue;
    public AStarNode parent;

    public AStarNode(MazeCoordinate coordinate, double startValue, double finishValue, AStarNode parent) {
        this.coordinate = coordinate;
        this.startValue = startValue;
        this.finishValue = finishValue;
        this.parent = parent;
    }

    public double getTotal(){
        return startValue+finishValue;
    }

    @Override
    public boolean equals(Object other){
        return ((AStarNode)other).coordinate.equals(coordinate);
    }
}
