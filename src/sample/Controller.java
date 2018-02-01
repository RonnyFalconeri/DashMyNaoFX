package sample;
import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class Controller {

    Application application = new Application(new String[]{}, "tcp://192.168.1.133:9559");
    Connection connection = new Connection(application);

    // declaration of GUI objects here

        // Connection
        @FXML Button ConnectionButton;
        @FXML TextField ConnectionIP;
        @FXML TextField ConnectionPort;
        @FXML Circle ConnectionStatus;

        // Speech
        @FXML Button SpeechButton;
        @FXML TextField SpeechText;
        @FXML ComboBox SpeechLanguage;
        @FXML Slider SpeechPitch;
        @FXML Slider SpeechVolumeSlider;

        // Posture
        @FXML Button PostureButton;
        @FXML ComboBox PostureComboBox;
        @FXML Slider PostureSpeedSlider;

        // AudioPlayer
        @FXML Button AudioPlayerButton;
        @FXML ComboBox AudioPlayerComboBox;

        // Movement
        @FXML Button MovementButtonW;
        @FXML Button MovementButtonA;
        @FXML Button MovementButtonS;
        @FXML Button MovementButtonD;
        @FXML Button MovementButtonStop;
        @FXML Slider MovementSliderVel;

        // Appereance
        @FXML Button AppereanceButtonSet;
        @FXML Button AppereanceButtonReset;
        @FXML ComboBox AppereanceComboBoxColor;
        @FXML ComboBox AppereanceComboBoxGroup;

        // BodyState
        @FXML Button BodyStateButton;
        @FXML Label BodyStateBatteryPerc;
        @FXML Label BodyStateLabelTemp;

        // HeadAlignment
        @FXML Button HeadAlButtonUp;
        @FXML Button HeadAlButtonRight;
        @FXML Button HeadAlButtonDown;
        @FXML Button HeadAlButtonLeft;
        @FXML Button HeadAlButtonCenter;


    // methods for GUI actions here

        // GUI modification
        private void changeButtonText(Button ButtonName, String Text){ ButtonName.setText(Text);}public Controller() throws Exception {}

        private void changeLabelText(Label Labelname, String Text){
            Labelname.setText(Text);
        }

        private void changeTextfieldText(TextField TextFieldName, String Text){
        TextFieldName.setText(Text);
    }

        private void changeConnectionState(boolean state){
            // TODO: change the connection state of GUI
        }


        // Connection
        int amountClicked=0;

        public void clickConnectionButton(ActionEvent actionEvent) throws Exception {
            amountClicked++;

            if (amountClicked < 2) {
                // connect for the first time
                connection.buildNewConnection();

                // GUI modification
                changeConnectionState(true);
                changeButtonText(ConnectionButton, "Disconnect");
            } else {
                // was connected at least once
                if (connection.isConnected()) {
                    // kill connection
                    connection.killConnection();

                    // GUI modification
                    changeConnectionState(false);
                    changeButtonText(ConnectionButton, "Connect");
                } else {
                    // build connection
                    connection = new Connection(this.application);
                    connection.setIP_Adress(ConnectionIP.getText());
                    connection.setPort(ConnectionPort.getText());
                    connection.buildNewConnection();

                    // GUI modification
                    changeConnectionState(true);
                    changeButtonText(ConnectionButton, "Disconnect");
                }
            }

        }

        public void changeIP_Adress(KeyEvent keyEvent) {
            connection.setIP_Adress(ConnectionIP.getText());
        }

        public void changePort(KeyEvent keyEvent) {
            connection.setPort(ConnectionPort.getText());
        }


        // Speech
        public void clickSpeechButton(ActionEvent actionEvent) throws Exception {connection.getSpeech().sayText();}

        public void changeSpeechText(KeyEvent keyEvent) {connection.getSpeech().setSpeechtext(SpeechText.getText());}

        public void changeLanguage(ActionEvent actionEvent) {
            connection.getSpeech().setLanguage(SpeechLanguage.getSelectionModel().getSelectedItem().toString());
        }

        public void changePitch(MouseEvent mouseEvent) {
            connection.getSpeech().setPitch((int)SpeechPitch.getValue());
        }

        public void changeSpeechVolume(MouseEvent mouseEvent) {
            float vol = (float) SpeechVolumeSlider.getValue();
            connection.getSpeech().setSpeechVolume(vol);
        }


        // Posture
        public void clickPostureButton(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getPosture().posePosture();
        }

        public void changePosture(ActionEvent actionEvent) {
            connection.getPosture().setPosture(PostureComboBox.getSelectionModel().getSelectedItem().toString());
        }

        public void changePostureSpeed(MouseEvent mouseEvent) {
            float speed = (float) PostureSpeedSlider.getValue();
            connection.getPosture().setSpeed(speed);
        }


        // AudioPlayer
        public void clickAudioPlayerButton(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getAudioplayer().playAudiosample();
        }

        public void changeAudioPlayerAudiosample(ActionEvent actionEvent) {
            connection.getAudioplayer().setAudiosample(AudioPlayerComboBox.getSelectionModel().getSelectedItem().toString());
        }


        // Movement
        public void clickMovementButtonW(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveBodyForward();
        }

        public void clickMovementButtonA(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().changeMovementDirectionLeft();
        }

        public void clickMovementButtonS(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveBodyBackwards();
        }

        public void clickMovementButtonD(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().changeMovementDirectionRight();
        }

        public void clickMovementButtonStop(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().stopMovement();
        }

        public void clickMovementKey(KeyEvent keyEvent) throws CallError, InterruptedException {
            System.out.print("key pressed: ");
            if(keyEvent.getText().equals("w")){
                System.out.println("w pressed");
                connection.getMovement().moveBodyForward();
            } else if(keyEvent.getText().equals("a")){
                System.out.println("a pressed");
                connection.getMovement().changeMovementDirectionLeft();
            } else if(keyEvent.getText().equals("s")){
                System.out.println("s pressed");
                connection.getMovement().moveBodyBackwards();
            } else if(keyEvent.getText().equals("d")){
                System.out.println("d pressed");
                connection.getMovement().changeMovementDirectionRight();
            } else if(keyEvent.getText().equals(" ")){
                System.out.println("space pressed");
                connection.getMovement().stopMovement();
            }
        }

        public void changeMovementVel(MouseEvent mouseEvent) {
            connection.getMovement().setVelocity((float)MovementSliderVel.getValue());
        }


        // Appereance
        public void clickAppereanceButtonReset(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getAppereance().resetLEDs();
        }

        public void clickAppereanceButtonSet(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getAppereance().changeLEDColor();
        }

        public void changeAppereanceGroup(ActionEvent actionEvent) {
            connection.getAppereance().setGroup(AppereanceComboBoxGroup.getSelectionModel().getSelectedItem().toString());
        }

        public void changeAppereanceColor(ActionEvent actionEvent) {
            connection.getAppereance().setColor(AppereanceComboBoxColor.getSelectionModel().getSelectedItem().toString());
        }


        // BodyState
        public void clickBodyStateButton(ActionEvent actionEvent) throws InterruptedException, CallError {
            // get battery percentage
            String BatteryPerc;
            BatteryPerc = connection.getBodystate().getBatteryPercentage()+" %";
            changeLabelText(BodyStateBatteryPerc, BatteryPerc);

            // get temperature
            String Temp;
            Temp = connection.getBodystate().getTemperature();
            changeLabelText(BodyStateLabelTemp,Temp);
        }


        // HeadAlignment
        public void clickHeadAlButtonUp(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getHeadalignment().moveHeadUp();
        }

        public void clickHeadAlButtonDown(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getHeadalignment().moveHeadDown();
        }

        public void clickHeadAlButtonCenter(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getHeadalignment().moveHeadCenter();
        }

        public void clickHeadAlButtonLeft(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getHeadalignment().moveHeadLeft();
        }

        public void clickHeadAlButtonRight(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getHeadalignment().moveHeadRight();
        }


}