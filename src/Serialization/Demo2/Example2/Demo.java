package Serialization.Demo2.Example2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class Demo {

    /* If we want the 'SavedGame' class to be
       serializable, is it needed all these classes
       to be serializable? Yes

       For example, we do not want the field
       'territoriesInfo' is in the file, then we
       use the keyword 'transient'(SavedGame class)
     */

    public static void main(String[] args) throws IOException {
        TerritoriesInfo territoriesInfo = new TerritoriesInfo("Spain - 6 areas, France - 8 areas");
        ResourcesInfo resourcesInfo = new ResourcesInfo("Spain - 100gold, France - 200gold");

        SavedGame savedGame = new SavedGame(territoriesInfo, resourcesInfo);

        FileOutputStream fos = new FileOutputStream(Path.of(
                "src", "Serialization", "Demo2", "Example2", "savedgame.txt"
        ).toFile());
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(savedGame);

        oos.close();
    }
}
