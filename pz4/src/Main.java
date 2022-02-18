import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        WarCar warCar = new WarCar(9.0, 8, "UkrOboronProm"
                , new Weapon("Browning M2", 12.7, 600, 3000));
        WarCar warCar1 = new WarCar(8.2, 6, "Oshkosh Defense"
                , new Weapon("Browning M2", 12.7, 600, 3000));
        WarCar warCar2 = new WarCar(6.4, 9, "UkrOboronProm"
                , new Weapon("PKT", 7.62, 800, 2000));

        String path = "D:/temp/warcars.txt";

        List<WarCar> warCars = new ArrayList<>(Arrays.asList(
                warCar, warCar1, warCar2
        ));

        List<WarCar> warCars1 = new ArrayList<>();

        try
        {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(warCars);
            out.close();
            fileOut.close();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }

        try
        {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            warCars1 = (List<WarCar>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }

        warCars1.stream().forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Вивести відсортовані дані за критерієм:\n\t1 - об'єм двигуна,\n\t2 - кількість сидінь," +
                "\n\t3 - кількість патронів,\n\t4 - дальність вогню.");
        switch (scanner.nextLine()){
            case "1":
                warCars1.stream().sorted(Comparator.comparing(Car::getEngineVolume))
                        .forEach(System.out::println); break;
            case "2":
                warCars1.stream().sorted(Comparator.comparingInt(Car::getCountOfSeats))
                        .forEach(System.out::println); break;
            case "3":
                warCars1.stream().sorted(Comparator.comparingInt(wc -> wc.getWeapon().getRounds()))
                        .forEach(System.out::println); break;
            case "4":
                warCars1.stream().sorted(Comparator.comparingInt(wc -> wc.getWeapon().getFiringRange()))
                        .forEach(System.out::println); break;
        }
    }
}
