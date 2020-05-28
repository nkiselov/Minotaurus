package MazeUtilities.Square;

import MazeUtilities.MazeCoordinate;

public class SquareCoordinate implements MazeCoordinate {
    public int x;
    public int y;

    public SquareCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other){
        SquareCoordinate ot = (SquareCoordinate)other;
        return ot.x==x && ot.y == y;
    }

    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
}
