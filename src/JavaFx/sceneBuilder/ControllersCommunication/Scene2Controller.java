package JavaFx.sceneBuilder.ControllersCommunication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Controller {

    @FXML
    Label nameLabel;

    public void displayName(String username) { nameLabel.setText("HELLO: " + username); }
}
