package MazeGenerators.Kruskal;

import MazeGenerators.GeneratorOptions;
import MazeGenerators.GeneratorType;

public class KruskalOptions implements GeneratorOptions {

    @Override
    public GeneratorType getGeneratorType() {
        return GeneratorType.KRUSKAL;
    }
}
