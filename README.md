# Minotaurus

Universal Maze Generator 

## How to use

Minotaurus is very simple to use

### Generating maze
```java
//Backtracker 10x10 maze starting at (5,5)
Maze maze = MazeGenerator.generateMaze(new BacktrackerOptions(new SquareCoordinate(5,5)), new SquareMazeOptions(10,10));

//Kruskal 10x15 maze
Maze maze = MazeGenerator.generateMaze(new KruskalOptions(), new SquareMazeOptions(10,15));

//Prim 1000x2000 maze starting at (0,0)
Maze maze = MazeGenerator.generateMaze(new PrimOptions(new SquareCoordinate(0,0)), new SquareMazeOptions(1000,2000));
```

### Rendering maze
```java
//Render square maze 10 pixels per tile and output to maze.png
MazeRenderer.saveMaze(maze, new SquareMazeRendererOptions(10),new File("maze.png"),"png");
```

### Finding and rendering solution
```java
//Create 50x50 maze using backtracker starting at (10,10)
Maze maze = MazeGenerator.generateMaze(new BacktrackerOptions(new SquareCoordinate(10,10)), new SquareMazeOptions(50,50));

//Render maze
MazeImage mazeImage = MazeRenderer.renderMaze(maze, new SquareMazeRendererOptions(10));

//Save maze image without solution
MazeRenderer.saveMazeImage(mazeImage,new File("maze.png"),"png");

//Generate solution using AStar
MazePath solution = AStar.solve(maze);

//Draw solution overlay red
MazeRenderer.drawOverlayPath(mazeImage,solution, Color.red);

//Save maze image with solution
MazeRenderer.saveMazeImage(mazeImage,new File("mazeWithSolution.png"),"png");
```

## Supported maze generating algorithms

* Backtracker

* Kruskal's

* Prim's

## Supported path finding algorithms

* A*

## Supported layouts

* Square maze
