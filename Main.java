import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Wall wall = new Wall(Arrays.asList(
                new CustomBlock("Czerwony", "Cegła"),
                new CustomBlock("Niebieski", "Kostka"),
                new CustomBlock("Zielony", "Drzewo"),
                new CustomBlock("Biały", "Drzewo")));

        // Testowanie metod
        System.out.println("Kolor " + wall.getColor());
        System.out.println("Materiał " + wall.getMaterial());

        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj kolor");
        var color = scan.nextLine();

        Optional<Block> foundBlock = wall.findBlockByColor(color);
        System.out.println("Kolor klocka:  " + color + ": " + foundBlock.orElse(null)); // zwraca adres

        System.out.println("Podaj Materiał");
        var material = scan.nextLine();

        List<Block> blocksByMaterial = wall.findBlocksByMaterial(material);
        System.out.println("Materiał klocka: " + material + ": " + blocksByMaterial);

        System.out.println("Liczba klocków: " + wall.count());
        scan.close();
    }
}

class CustomBlock implements Block {
    private String color;
    private String material;

    // Konstruktor
    public CustomBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
