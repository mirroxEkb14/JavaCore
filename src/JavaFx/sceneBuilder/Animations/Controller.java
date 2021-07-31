package JavaFx.sceneBuilder.Animations;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ImageView myImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        // translate
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(myImageView);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(250);
        translate.setByY(-250);
        translate.setAutoReverse(true);
        translate.play();
         */

        /*
        // rotate
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myImageView);
        rotate.setDuration(Duration.millis(500));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(360);
//        rotate.setAxis(Rotate.X_AXIS); // Y_AXIS, Z_AXIS(default)
        rotate.play();
         */

        /*
        // fade
        FadeTransition fade = new FadeTransition();
        fade.setNode(myImageView);
        fade.setDuration(Duration.millis(1000));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
         */

        // scale
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(myImageView);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(2.0);
        scale.setByY(2.0);
        scale.setAutoReverse(true);
        scale.play();
    }
}
