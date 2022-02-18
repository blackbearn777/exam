public class Main {
    public static void main(String[] args) {

        //Переконайся, що встановлено Maven-dependency org.xerial:sqlite-jdbc:3.34.0
        //Встановлювати в File->Project sctructure...->Modules->Dependencies->"+"->Library...->From Maven

        Inventory inventory = new Inventory("Inventory");

        inventory.createNewDB("Inventory");
        inventory.createTable("Inventory", "Inventory");

        //Додавання записів
        /*inventory.insert("Inventory", "vinyk", 1, 4, 50);
        inventory.insert("Inventory", "stil", 3, 2, 650);
        inventory.insert("Inventory", "stilets`", 1, 6, 170);
        inventory.insert("Inventory", "doshka", 3, 1, 400);
        inventory.insert("Inventory", "shafa", 2, 1, 750);*/

        //Для видалення необхідних записів підставити індекси замість 'x'
        /*for (int i=1; i<= x; i++)
            inventory.delete("Inventory", i);*/

        inventory.selectAll("Inventory");
    }
}
