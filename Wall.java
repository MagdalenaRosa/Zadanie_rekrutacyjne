import java.util.List;
import java.util.Optional;

// --------------------------------------
// zaimplementowanie metod :
//  * findBlockByColor,
//  * findBlocksByMaterial,
//  * count w klasie Wall
//  * Cała logika w klasie Wall
// --------------------------------------

interface Block {
    String getColor();

    String getMaterial();
}

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}

interface Structure {
    Optional<Block> findBlockByColor(String color);

    List<Block> findBlocksByMaterial(String material);

    int count();
}

public class Wall implements CompositeBlock, Structure {
    private List<Block> blocks;

    // konstructor
    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }
    // implemetnacja metod dla interfejsu CompositeBlock

    @Override
    public String getColor() {
        return blocks.isEmpty() ? "" : blocks.get(0).getColor();
    }

    @Override
    public String getMaterial() {
        return blocks.isEmpty() ? "" : blocks.get(0).getMaterial();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    // Implementacja metod dla interfejsu Structure:
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> color.equals(block.getColor()))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> material.equals(block.getMaterial()))
                .toList();
    }

    @Override
    public int count() {
        return blocks.size();
    }

}
