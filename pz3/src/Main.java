import java.io.*;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal(40.0, 25.0, 8, "female", "bulldog`");
        Animal animal1 = new Animal(); //без серіалізованого значення breed

        Human human = new Human(175.0, 75.0, 32, "male", "ukrayinets`");
        Human human1 = new Human(); //з серіалізованим значенням nation
        String path = "D:/temp/animal.dat";
        String path1 = "D:/temp/human.dat";

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try
        {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(animal);
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
            animal1 = (Animal) in.readObject();
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

        System.out.println(animal1);//виведе тваринку з полем breed='null'
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        File file = new File(path1);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(human);
        } catch (IOException e){
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
            human1 = (Human)in.readObject();
        } catch (ClassNotFoundException | IOException e){
            e.printStackTrace();
        }

        System.out.println(human1);//виведе людинку із заповненим полем nation='ukrayinets`', хоча воно transient!
    }
}
