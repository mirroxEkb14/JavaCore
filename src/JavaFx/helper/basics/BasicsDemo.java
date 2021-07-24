package JavaFx.helper.basics;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BasicsDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        /* create a window */

        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK); // adds a background color to the window

        // add an icon
        Image icon = new Image("JavaFx/helper/basics/icon.png");
        stage.getIcons().add(icon);

        stage.setTitle("Stage Demo Program w00t w00t"); // set title

        // set width and height
        stage.setWidth(500);
        stage.setHeight(500);

        stage.setResizable(false); // cant resize the stage

        // where the stage will pear(top left corner)
        stage.setX(50);
        stage.setY(50);

        stage.setFullScreen(true); // full screen mode
        stage.setFullScreenExitHint("YOU CANT ESCAPE unless to press q"); // the hint in full-screen mode
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q")); // to exit full-screen mode -> "q"

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
