package MazeUtilities.Triangular;

import MazeUtilities.MazeDirection;

public class TriangularDirection implements MazeDirection {
    public int dx;
    public int dy;
    public int index;

    public static int[] directions = {1, 2, 4};
    public static int[] dxi = {0, 0, -1};
    public static int[] dyi = {0, -1, 0};

    public TriangularDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        index = 2*Math.abs(dx)+Math.abs(dy);
    }



    public TriangularDirection(int index, boolean z) {
        this.dx = dxi[index];
        this.dy = dyi[index];
        if(z){
            this.dx=-this.dx;
            this.dy=-this.dy;
        }
        this.index = index;
    }

    public int getValue(){
        return directions[index];
    }

    @Override
    public MazeDirection getOpposite() {
        return new TriangularDirection(-dx,-dy);
    }
}
