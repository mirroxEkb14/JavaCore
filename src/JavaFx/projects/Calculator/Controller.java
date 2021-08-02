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

    private boolean number1Flag = false;
    private boolean number2Flag = false;

    private boolean cleanLabel = true;
    private boolean byZeroError = false;

    public void processNumbers(ActionEvent event) {

        String currentNumber = ((Button) event.getSource()).getText();
        String labelText = myLabel.getText();

        if (cleanLabel) {
            myLabel.setText(currentNumber);
            number1Flag = true;
            cleanLabel = false;
        } else {
            if (sign != null) number2Flag = true;

            myLabel.setText(labelText + currentNumber);
        }
    }

    public void processSigns(ActionEvent event) {

        String currentSign = ((Button) event.getSource()).getText();

        if (!currentSign.equals("=")) {
            if (sign != null) return;

            if (!number1Flag) {
                cleanLabel = false;
                number1Flag = true;
            }

            sign = currentSign;
            number1 = Long.parseLong(myLabel.getText());
            myLabel.setText(myLabel.getText() + sign);

        } else {
            if (!number1Flag || !number2Flag) return;

            String labelText = myLabel.getText();

            switch (sign) {
                case "+" -> number2 = Long.parseLong(labelText.split("\\+")[1]);
                case "*" -> number2 = Long.parseLong(labelText.split("\\*")[1]);
                default -> number2 = Long.parseLong(labelText.split(sign)[1]);
            }

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

            resetValues();
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
            case "%":
                return
            default:
                return 0;
        }
    }

    private void resetValues() {
        number1 = 0.0F;
        number2 = 0.0F;
        sign = null;
        number1Flag = false;
        number2Flag = false;
        cleanLabel = true;
    }

    private boolean isWholeNumber(float result) {
        return Integer.parseInt(Float.toString(result).split("\\.")[1]) == 0;
    }
}
