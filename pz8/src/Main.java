import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        List<Equipment> equipment = new ArrayList<>(Arrays.asList(
                new Equipment("chair", 1, 4, 145.0),
                new Equipment("table", 3, 3, 450.0),
                new Equipment("laptop", 1, 5, 25000.0),
                new Equipment("TV", 3, 1, 35000.0),
                new Equipment("sofa", 4, 1, 678.0),
                new Equipment("desk", 4, 1, 232.0),
                new Equipment("armchair", 2, 2, 540.0),
                new Equipment("PC", 1, 2, 14000.0),
                new Equipment("wardrobe", 5, 1, 46000.0),
                new Equipment("chair", 1, 4, 145.0)
        ));

        List<Equipment> uniqueElements = Equipment.uniqueElements(equipment);
        System.out.println("Унікальні 9 елементів:");
        uniqueElements.forEach(System.out::println);

        System.out.println("\n-----------------------------------------------\n");

        System.out.println("Елементи, що мають розмір більше за 2:");
        List<Equipment> sizedList = Equipment.sizedList(equipment, 2);
        sizedList.forEach(System.out::println);
    }
}
