package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

public class Controller {

    // declaration of GUI objects here
    @FXML
    Button myButton;

    @FXML
    Label myLabel;

    @FXML
    TextField myTextfield;


    // instanciate new objects here
    Connection connection = new Connection();
    Speech speech = new Speech(connection);


    // methods for GUI actions here
    public void clickButton(ActionEvent actionEvent) throws Exception{
        System.out.println("Button wurde geklickt!");
        speech.sayText();
    }

    public void textChanged(KeyEvent keyEvent) {
        String Inputtext = myTextfield.getText();
        speech.setSpeechtext(Inputtext);
    }

    public void clickLetsGo(ActionEvent actionEvent) {

    }
}