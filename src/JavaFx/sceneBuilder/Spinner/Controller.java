package JavaFx.sceneBuilder.Spinner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Spinner<Integer> mySpinner;
    @FXML
    private Label myLabel;

    int currentValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);

        valueFactory.setValue(1);
        mySpinner.setValueFactory(valueFactory);
        updateLabel();

        mySpinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                updateLabel();
            }
        });
    }

    private void updateLabel() {
        currentValue = mySpinner.getValue();
        myLabel.setText(Integer.toString(currentValue));
    }
}
