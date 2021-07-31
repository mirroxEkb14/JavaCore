package JavaFx.sceneBuilder.DatePicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Controller {

    @FXML
    private Label myLabel;
    @FXML
    private DatePicker myDatePicker;

    public void getDate(ActionEvent event) {
        LocalDate myDate = myDatePicker.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy", Locale.ENGLISH));
        myLabel.setText(myFormattedDate);
    }
}
