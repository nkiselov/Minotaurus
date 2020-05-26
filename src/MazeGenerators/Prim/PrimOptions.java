package MazeGenerators.Prim;

import MazeCoordinates.MazeCoordinate;
import MazeGenerators.GeneratorOptions;
import MazeGenerators.GeneratorType;

public class PrimOptions implements GeneratorOptions {
    public MazeCoordinate start;

    public PrimOptions(MazeCoordinate start) {
        this.start = start;
    }

    @Override
    public GeneratorType getGeneratorType() {
        return GeneratorType.PRIM;
    }
}
