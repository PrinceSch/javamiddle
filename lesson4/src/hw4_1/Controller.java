package hw4_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public javafx.scene.control.TextArea textArea;
    @FXML
    public TextField textField;

    public void onClickBtn(ActionEvent actionEvent) {
        textArea.appendText("User: "+textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }

    public void onEnter(ActionEvent actionEvent) {
        textArea.appendText("User: "+textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }
}
