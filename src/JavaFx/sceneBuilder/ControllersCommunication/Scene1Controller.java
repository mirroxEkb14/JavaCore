package JavaFx.sceneBuilder.ControllersCommunication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller {

    @FXML
    TextField nameTextField;

    private Parent root;
    private Scene scene;
    private Stage stage;

    public void login(ActionEvent event) throws IOException {
        String username = nameTextField.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample2.fxml"));
        root = loader.load();
        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.displayName(username);

//        root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
