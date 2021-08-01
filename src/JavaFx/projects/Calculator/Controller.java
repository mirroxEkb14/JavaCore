package JavaFx.projects.Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label myLabel;

    private float number1;
    private float number2;
    private String sign;


    private boolean cleanLabel = true;
    private boolean byZeroError = false;

    public void processNumbers(ActionEvent event) {

        // get pressed number
        String currentNumber = ((Button) event.getSource()).getText();
        String labelText = myLabel.getText();

        if (cleanLabel) {
            myLabel.setText(currentNumber);
            cleanLabel = false;
        } else {
            myLabel.setText(labelText + currentNumber);
        }
    }

    public void processSigns(ActionEvent event) {

        // get pressed sign
        String currentSign = ((Button) event.getSource()).getText();

        // after entering the first number, the user enters a sign(not '='),
        // so on this step we have the first number and the sign
        if (!currentSign.equals("=")) {
            sign = currentSign;
            number1 = Long.parseLong(myLabel.getText());
            myLabel.setText(myLabel.getText() + sign); // show the sign

        } else {
            String labelText = myLabel.getText();
            if (labelText.length() == 1 || )

            // get the second number
            if (sign.equals("+")) number2 = Long.parseLong(labelText.split("\\+")[1]);
            else if (sign.equals("*")) number2 = Long.parseLong(labelText.split("\\*")[1]);
            else number2 = Long.parseLong(labelText.split(sign)[1]);

            float result = calculate();

            if (!byZeroError) {
                if (isWholeNumber(result))
                    myLabel.setText(Float.toString(result).split("\\.")[0]);
                else
                    myLabel.setText(Float.toString(result));

            } else {
                myLabel.setText("Can`t divide by zero");
                byZeroError = false;
            }

            // reset the values after the calculation
            number1 = 0.0F;
            number2 = 0.0F;
            sign = null;
            cleanLabel = true;
        }
    }

    public float calculate() {
        switch (sign) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "/":
                if (number2 == 0) {
                    byZeroError = true;
                    return 0;
                } else return number1 / number2;
            case "*":
                return number1 * number2;
            default:
                return 0;
        }
    }

    private boolean isWholeNumber(float result) {
        return Float.toString(result).split("\\.")[1].length() == 1;
    }
}
