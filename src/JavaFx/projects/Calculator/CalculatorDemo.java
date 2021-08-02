package JavaFx.projects.Calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class CalculatorDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);

        Image windowIcon = new Image(new File(
                "src/JavaFx/projects/Calculator/images/calc.png").toURI().toString());
        stage.getIcons().add(windowIcon);

        stage.setTitle("Calculator");

        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(args); }
}
