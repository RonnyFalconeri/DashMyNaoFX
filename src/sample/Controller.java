package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;


public class Controller {
    @FXML
    Button myButton;

    @FXML
    Label myLabel;

    @FXML
    TextField myTextfield;

    Connection connection = new Connection();
    Speech speech = new Speech(connection);

    public void clickButton(ActionEvent actionEvent) throws Exception{
        System.out.println("Button wurde geklickt!");
        speech.sayText();
    }


    public void textChanged(KeyEvent keyEvent) {
        String Inputtext = myTextfield.getText();
        speech.setSpeechtext(myTextfield.getText());
    }
}
