package MazeGenerators.Backtracker;

import Mazes.SquareMaze;

import java.util.Stack;

public class SquareBacktracker{
    int width;
    int height;
    int[][] grid;
    Stack<Vector2> visited = new Stack<>();

    public SquareMaze generateMaze(SquareBacktrackerOptions bp){
        this.width=bp.width;
        this.height=bp.height;
        grid = new int[width][height];
        carve(new Vector2(bp.startX,bp.startY));
        for (int i=0; i<4; i++){
            int dx = SquareMaze.dx[i];
        }
        return new SquareMaze(grid,width,height);
    }

    void carve(Vector2 start){
        Vector2 cp = start;
        main:
        while(true) {
            int[] indeces = {0, 1, 2, 3};
            shuffle(indeces);
            for (int i : indeces) {
                int nx = cp.x + SquareMaze.dx[i];
                int ny = cp.y + SquareMaze.dy[i];
                if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                    if(grid[nx][ny]==0) {
                        grid[cp.x][cp.y] |= SquareMaze.directions[i];
                        grid[nx][ny] |= SquareMaze.opposite[i];
                        visited.push(cp);
                        cp = new Vector2(nx, ny);
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
    }

    void shuffle(int[] array){
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

    public class Vector2{
        public int x;
        public int y;

        public Vector2(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
