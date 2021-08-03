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

    private float calcResult;

    private boolean number1Flag = false;
    private boolean number2Flag = false;
    private boolean percentSignFlag = false;

    private boolean cleanLabel = true;
    private boolean byZeroError = false;

    public void processNumbers(ActionEvent event) {

        String currentNumber = ((Button) event.getSource()).getText();
        String labelText = myLabel.getText();

        if (cleanLabel) {
            if (currentNumber.equals("."))
                myLabel.setText(labelText + currentNumber);
            else
                myLabel.setText(currentNumber);

            number1Flag = true;
            cleanLabel = false;

        } else {
            if (Character.toString(labelText.charAt(labelText.length() - 1)).equals(".") && currentNumber.equals("."))
                return;
            else if (sign != null)
                number2Flag = true;

            myLabel.setText(labelText + currentNumber);
        }
    }

    public void processSigns(ActionEvent event) {

        String currentSign = ((Button) event.getSource()).getText();
        String labelText = myLabel.getText();

        if (currentSign.equals("C")) {
            myLabel.setText("0");
            resetValues();

        } else if (currentSign.equals("%")) {
            if (!number2Flag) return;

            number2 = number1 / 100 * getNumber2(labelText);

            if (isWholeNumber(number1) && isWholeNumber(number2))
                myLabel.setText(String.format("%d%s%d", (int) number1, sign, (int) number2));
            else if (isWholeNumber(number1))
                myLabel.setText(String.format("%d%s%f", (int) number1, sign, number2));
            else
                myLabel.setText(String.format("%f%s%d", number1, sign, (int) number2));

            percentSignFlag = true;

        } else if (!currentSign.equals("=")) {
            if (!number1Flag) {
                cleanLabel = false;
                number1Flag = true;
            }

            if (sign != null) return;

            number1 = Float.parseFloat(labelText);
            sign = currentSign;
            myLabel.setText(labelText + sign);

        } else {
            if (!number2Flag) return;

            if (!percentSignFlag) number2 = getNumber2(labelText);

            calcResult = calculate();

            if (!byZeroError) {
                if (isWholeNumber(calcResult))
                    myLabel.setText(Float.toString(calcResult).split("\\.")[0]);
                else
                    myLabel.setText(Float.toString(calcResult));

            } else {
                myLabel.setText("Can`t divide by zero");
                byZeroError = false;
            }
            resetValues();
        }
    }

    public void erase() {
        if (myLabel.getText().length() == 1) {
            myLabel.setText("0");
            cleanLabel = true;
        } else {
            myLabel.setText(myLabel.getText().substring(0, myLabel.getText().length() - 1));
        }
    }

    public void pow() {
        if (!number1Flag && !number2Flag && sign == null && calcResult != 0.0F) {
            double powCaclResult = Math.pow(Float.parseFloat(myLabel.getText()), 2);

            if (isWholeNumber((float) powCaclResult))
                myLabel.setText(Integer.toString((int) powCaclResult));
            else
                myLabel.setText(Double.toString(powCaclResult));

        } else if (number1Flag && sign == null) {
            number1 = Float.parseFloat(myLabel.getText());

            if (isWholeNumber(number1))
                myLabel.setText(Integer.toString((int) (number1 * number1)));
            else
                myLabel.setText(Float.toString(number1 * number1));

            calcResult = number1;
            resetValues();
        }
    }

    private float calculate() {
        switch (sign) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "/":
                if (number2 == 0) {
                    byZeroError = true;
                    return 0.0F;
                } else return number1 / number2;
            case "*":
                return number1 * number2;
            default:
                return 0.0F;
        }
    }

    private float getNumber2(String labelText) {
        return switch (sign) {
            case "+" -> Float.parseFloat(labelText.split("\\+")[1]);
            case "*" -> Float.parseFloat(labelText.split("\\*")[1]);
            default -> Float.parseFloat(labelText.split(sign)[1]);
        };
    }

    private void resetValues() {
        number1 = 0.0F;
        number2 = 0.0F;
        sign = null;
        number1Flag = false;
        number2Flag = false;
        cleanLabel = true;
    }

    // 52587895E11
    private boolean isWholeNumber(float result) {
        return Long.parseLong(Float.toString(result).split("\\.")[1]) == 0;
    }
}
