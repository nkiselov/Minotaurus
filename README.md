# Minotaurus

Universal Maze Generator 

## How to use

```java
//Backtracker 10x10 maze starting at (5,5)
Maze maze = MazeGenerator.generateMaze(new BacktrackerOptions(new SquareCoordinate(5,5)), new SquareMazeOptions(10,10));

//Kruskal 10x15 maze
Maze maze = MazeGenerator.generateMaze(new KruskalOptions(), new SquareMazeOptions(10,15));

//Prim 1000x2000 maze starting at (0,0)
Maze maze = MazeGenerator.generateMaze(new PrimOptions(new SquareCoordinate(0,0)), new SquareMazeOptions(1000,2000));

//Render square maze 10 pixels per tile and output to maze.png
MazeRenderer.saveMaze(maze, new SquareMazeRendererOptions(10),new File("maze.png"),"png");
```

## Supported algorithms

* Backtracker

* Kruskal's

* Prim's

## Supported layouts

* Square maze
