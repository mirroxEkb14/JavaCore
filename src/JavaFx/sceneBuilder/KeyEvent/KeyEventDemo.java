package JavaFx.sceneBuilder.KeyEvent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP -> controller.moveUp();
                case DOWN -> controller.moveDown();
                case LEFT -> controller.moveLeft();
                case RIGHT -> controller.moveRight();
                case W -> System.out.println("W");
                case A -> System.out.println("A");
                case S -> System.out.println("S");
                case D -> System.out.println("D");
                default -> System.out.println("Default unit");
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
