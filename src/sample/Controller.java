package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    Button myButton;

    @FXML
    Label myLabel;

    public void clickButton(ActionEvent actionEvent) {
        System.out.println("Button wurde geklickt!");

        myLabel.setText("Label wurde geändert.");
    }
}
