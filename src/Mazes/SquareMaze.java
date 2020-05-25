package Mazes;

public class SquareMaze implements Maze {
        public int[][] grid;
        public int width;
        public int height;
        public static int[] directions={1,2,4,8};
        public static int[] dx = {1,0,-1,0};
        public static int[] dy = {0,-1,0,1};
        public static int[] opposite = {4,8,1,2};

        public SquareMaze(int[][] grid, int width, int height) {
            this.grid = grid;
            this.width = width;
            this.height = height;
        }

    @Override
    public MazeType getMazeType() {
        return MazeType.SQUARE;
    }
}
