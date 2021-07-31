package JavaFx.sceneBuilder.RadioButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Controller {

    @FXML
    private Label myLabel;
    @FXML
    private RadioButton rPizzaButton, rSushiButton, rRamenButton;

    public void getFood(ActionEvent event) {
        if (rPizzaButton.isSelected()) myLabel.setText(rPizzaButton.getText());
        else if(rSushiButton.isSelected()) myLabel.setText(rSushiButton.getText());
        else myLabel.setText(rRamenButton.getText());
    }
}
