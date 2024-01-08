import java.util.List;
import java.util.Optional;

interface Block {
    String getColor();

    String getMaterial();
}

interface CompositeBlock extends Block {
    List<Block> getBlocks();
}

interface Structure {
    // zwraca dowolny element o podanym kolorze
    Optional<Block> findBlockByColor(String color);

    // zwraca wszystkie elementy z danego materiału
    List<Block> findBlocksByMaterial(String material);

    // zwraca liczbę wszystkich elementów tworzących strukturę
    int count();
}

public class Wall implements Structure {
    private List<Block> blocks;

}
