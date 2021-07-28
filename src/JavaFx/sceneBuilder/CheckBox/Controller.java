package JavaFx.sceneBuilder.CheckBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private CheckBox myCheckBox;
    @FXML
    private Label myLabel;
    @FXML
    private ImageView myImageView;

    Image myImage1 = new Image(getClass().getResourceAsStream("images/lightbulb1.jpg"));
    Image myImage2 = new Image(getClass().getResourceAsStream("images/lightbulb2.jpg"));

    public void change(ActionEvent event) {
        if (myCheckBox.isSelected()) {
            myImageView.setImage(myImage1);
            myLabel.setText("ON");
        } else {
            myImageView.setImage(myImage2);
            myLabel.setText("OFF");
        }
    }
}
