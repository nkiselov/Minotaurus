package MazeUtilities.Triangular;

import MazeUtilities.MazeCoordinate;

public class TriangularCoordinate implements MazeCoordinate {
    public int x;
    public int y;
    public boolean z;

    public TriangularCoordinate(int x, int y, boolean z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object other){
        TriangularCoordinate ot = (TriangularCoordinate)other;
        return ot.x==x && ot.y == y && ot.z==z;
    }

    @Override
    public String toString(){
        return "("+x+","+y+","+z+")";
    }
}
