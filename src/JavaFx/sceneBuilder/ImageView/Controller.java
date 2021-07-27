package JavaFx.sceneBuilder.ImageView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    ImageView myImageView;
    Button myButton;
    Image myImage1 = new Image(getClass().getResourceAsStream("shrek1.jpg"));
    Image myImage2 = new Image(getClass().getResourceAsStream("shrek2.jpg"));

    public void displayImage() {
        if (myImageView.getImage() == myImage2) myImageView.setImage(myImage1);
        else myImageView.setImage(myImage2);
    }
}
