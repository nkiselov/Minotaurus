package MazeGenerators.Backtracker;

import MazeCoordinates.MazeCoordinate;
import MazeGenerators.GeneratorOptions;
import MazeGenerators.GeneratorType;

public class BacktrackerOptions implements GeneratorOptions {
    public MazeCoordinate start;

    public BacktrackerOptions(MazeCoordinate start) {
        this.start = start;
    }

    @Override
    public GeneratorType getGeneratorType() {
        return GeneratorType.BACKTRACKER;
    }
}
