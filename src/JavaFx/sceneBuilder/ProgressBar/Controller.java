package JavaFx.sceneBuilder.ProgressBar;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ProgressBar myProgressBar;
    @FXML
    private Label myLabel;
    @FXML
    private Button myButton;

    DecimalFormat df = new DecimalFormat("#.#");
    double progress = 0.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myProgressBar.setStyle("-fx-accent: #00FF00;");
    }

    public void increaseProgress() {
        if (!df.format(progress).equals("1")) {
            progress += 0.1;
            System.out.println(df.format(progress));
            myProgressBar.setProgress(progress);
            myLabel.setText((int) Math.round(progress * 100) + "%");
        }
    }
}
