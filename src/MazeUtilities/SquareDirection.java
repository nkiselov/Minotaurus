package MazeUtilities;

public class SquareDirection implements MazeDirection {
    public int dx;
    public int dy;
    public int index;

    public static int[] directions = {1, 2, 4, 8};
    public static int[] dxi = {1, 0, -1, 0};
    public static int[] dyi = {0, -1, 0, 1};
    public static int[] opposites = {4, 8, 1, 2};

    public SquareDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        index = 2+dy-2*Math.max(dx,0);
    }

    public SquareDirection(int index) {
        this.dx = dxi[index];
        this.dy = dyi[index];
        this.index = index;
    }

    public int getValue(){
        return directions[index];
    }

    public int getOppositeValue(){
        return opposites[index];
    }

    @Override
    public MazeDirection getOpposite() {
        return new SquareDirection(-dx,-dy);
    }
}
