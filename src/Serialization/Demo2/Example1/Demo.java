package Serialization.Demo2.Example1;

import java.io.*;
import java.nio.file.Path;

public class Demo {

    /* Serialization - when we save the state of the program
       in byte sequence

       Deserialization - byte recovery process

       It is needed because all the programs interact with
       with each other, exchange data. It is more comfortable
       to do in byte format. For example, we play some game.
       We saved the game at a certain point and want to transfer
       it to another computer. With serialization, this saved game
       turns into byte sequence, we transfer it and then
       this byte sequence turns into saved game again(for instance,
       into Java-object)
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serialize();
        System.out.println(deserialize());
    }

    public static void serialize() throws IOException {
        // game data to save
        String[] territoryInfo = {"Spain - 6 areas", "France - 8 areas"};
        String[] resourcesInfo = {"Spain - 100gold", "France - 200gold"};

        SavedGame savedGame = new SavedGame(territoryInfo, resourcesInfo);

        // two threads to serialize the object and save it
        FileOutputStream fos = new FileOutputStream(Path.of(
                "src", "Serialization", "Demo2", "Example1", "savedgame.txt"
        ).toFile()); // write to file
        ObjectOutputStream oos = new ObjectOutputStream(fos); // turns into bytes

        // write to file
        oos.writeObject(savedGame);

        // close the thread
        oos.close();
    }

    public static SavedGame deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(Path.of(
                "src", "Serialization", "Demo2", "Example1", "savedgame.txt"
        ).toFile());
        ObjectInputStream ois = new ObjectInputStream(fis);

        return (SavedGame) ois.readObject();
    }
}
