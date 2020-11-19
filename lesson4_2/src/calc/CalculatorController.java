package calc;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController{

    Long num1, num2;
    boolean isOperatorPressed;
    String operatorPressed = "";

    @FXML
    TextField outputField;

    @FXML
    public void onNumberClick(ActionEvent actionEvent) {
        String value = ((Button) actionEvent.getSource()).getText();
        outputField.setText(outputField.getText() + value);
    }

    @FXML
    private void onOperatorClick(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operatorPressed.isEmpty()) {
                return;
            }
            operatorPressed = value;
            num1 = Long.parseLong(outputField.getText());
            outputField.setText("");
        } else {
            if (operatorPressed.isEmpty()) {
                return;
            }
            num2 = Long.parseLong(outputField.getText());
            switch (operatorPressed) {
                case "+":
                    outputField.setText(String.valueOf(num1 + num2));
                    break;
                case "-":
                    outputField.setText(String.valueOf(num1 - num2));
                    break;
                case "X":
                    outputField.setText(String.valueOf(num1 * num2));
                    break;
                case "/":
                    if (num2 == 0) { outputField.setText("0"); }
                    outputField.setText(String.valueOf(num1 / num2));
                    break;
            }
            operatorPressed = "";
        }
    }

    @FXML
    public void onDelClick(ActionEvent actionEvent) {
        if (outputField.getText().length() > 0) {
            outputField.setText(outputField.getText(0, outputField.getText().length() - 1));
        }
    }
}
