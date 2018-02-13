package sample;

import com.aldebaran.qi.CallError;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import java.io.IOException;

public class Controller {

    Connection connection = new Connection();

    // declaration of GUI objects here

    // Connection
    @FXML Button ConnectionButton;
    @FXML TextField ConnectionIP;
    @FXML TextField ConnectionPort;
    @FXML Circle ConnectionStatus;

    // Speech
    @FXML Tab SpeechTab;
    @FXML Button SpeechButton;
    @FXML TextField SpeechText;
    @FXML ComboBox SpeechLanguage;
    @FXML Slider SpeechPitch;
    @FXML Slider SpeechVolumeSlider;

    // Posture
    @FXML Tab PostureTab;
    @FXML Button PostureButton;
    @FXML ComboBox PostureComboBox;
    @FXML Slider PostureSpeedSlider;

    // AudioPlayer
    @FXML Tab AudioSampleTab;
    @FXML Button AudioPlayerButton;
    @FXML ComboBox AudioPlayerComboBox;

    // Movement
    @FXML Tab MovementTab;
    @FXML Pane MovementPane;
    @FXML Button MovementButtonW;
    @FXML Button MovementButtonA;
    @FXML Button MovementButtonS;
    @FXML Button MovementButtonD;
    @FXML Button MovementButtonStop;
    @FXML ToggleButton MovementSwitch;
    @FXML Slider MovementSliderVel;

    // Appearance
    @FXML Tab LedTab;
    @FXML Button AppearanceButtonSet;
    @FXML Button AppearanceButtonReset;
    @FXML ComboBox AppearanceComboBoxColor;
    @FXML ComboBox AppearanceComboBoxGroup;

    // BodyState
    @FXML Tab BodyStateTab;
    @FXML Button BodyStateButton;
    @FXML Label BodyStateBatteryPercentage;
    @FXML Label BodyStateLabelTemp;

    // HeadAlignment
    @FXML Tab HeadAlignmentTab;
    @FXML Button HeadAlButtonUp;
    @FXML Button HeadAlButtonRight;
    @FXML Button HeadAlButtonDown;
    @FXML Button HeadAlButtonLeft;
    @FXML Button HeadAlButtonCenter;

    // Behavior
    @FXML Tab BehaviorTab;
    @FXML Button BehaviorButtonStart;
    @FXML Button BehaviorButtonStop;
    @FXML ComboBox BehaviorComboBox;



        // Constructor
        public Controller() { }

    public void initialize() throws IOException {
        setLatestConnectionIP();
    }



    // methods for GUI actions here

        // GUI modification
        private void changeButtonText(Button pButtonName, String pText){
            pButtonName.setText(pText);
        }

        private void changeLabelText(Label pLabelName, String pText){
            pLabelName.setText(pText);
        }

        private void changeTextFieldText(TextField pTextFieldName, String pText){
            pTextFieldName.setText(pText);
        }

        private void disableTabs(boolean pValue){
            this.MovementTab.setDisable(pValue);
            this.SpeechTab.setDisable(pValue);
            this.PostureTab.setDisable(pValue);
            this.LedTab.setDisable(pValue);
            this.AudioSampleTab.setDisable(pValue);
            this.BodyStateTab.setDisable(pValue);
            this.HeadAlignmentTab.setDisable(pValue);
            this.BehaviorTab.setDisable(pValue);
        }

        private void changeConnectionState(boolean isConnected){
            if (isConnected){
                // connection is true, enable tabs
                ConnectionStatus.setFill(Paint.valueOf("0x08d833ff"));
                disableTabs(false);
            } else {
                // connection is false, disable tabs
                ConnectionStatus.setFill(Paint.valueOf("0xda0707ff"));
                disableTabs(true);
            }
        }

        public void setLatestConnectionIP() throws IOException {
            String LatestConnection = FileManager.readInFile();
            changeTextFieldText(ConnectionIP, LatestConnection);
        }


        // Connection
        private int amountClicked=0;
        public void clickConnectionButton(ActionEvent actionEvent) throws Exception {
            amountClicked++;
            if (amountClicked < 2) {
                // connect for the first time
                connection.setIP_Address(ConnectionIP.getText());
                connection.setPort(ConnectionPort.getText());
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
                    connection = new Connection();
                    connection.setIP_Address(ConnectionIP.getText());
                    connection.setPort(ConnectionPort.getText());
                    connection.buildNewConnection();

                        // GUI modification
                        changeConnectionState(true);
                        changeButtonText(ConnectionButton, "Disconnect");
                }
            }
        }

        public void changeIP_Address(KeyEvent keyEvent) {
            connection.setIP_Address(ConnectionIP.getText());
        }

        public void changePort(KeyEvent keyEvent) {
            connection.setPort(ConnectionPort.getText());
        }


        // Speech
        public void clickSpeechButton(ActionEvent actionEvent) throws Exception {
            connection.getSpeech().sayText();
        }

        public void changeSpeechText(KeyEvent keyEvent) {
            connection.getSpeech().setSpeechText(SpeechText.getText());
        }

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
            connection.getAudioPlayer().playAudioSample();
        }

        public void changeAudioPlayerAudioSample(ActionEvent actionEvent) {
            connection.getAudioPlayer().setAudioSample(AudioPlayerComboBox.getSelectionModel().getSelectedItem().toString());
        }


        // Movement
        public void clickMovementSwitch(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().changeMode(MovementSwitch.isSelected());
        }


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
                connection.getMovement().moveBodyForward();
            } else if(keyEvent.getText().equals("a")){
                connection.getMovement().changeMovementDirectionLeft();
            } else if(keyEvent.getText().equals("s")){
                connection.getMovement().moveBodyBackwards();
            } else if(keyEvent.getText().equals("d")){
                connection.getMovement().changeMovementDirectionRight();
            } else if(keyEvent.getText().equals(" ")){
                connection.getMovement().stopMovement();
            }
        }

        public void changeMovementVel(MouseEvent mouseEvent) {
            connection.getMovement().setVelocity((float)MovementSliderVel.getValue());
        }


        public void clickMovementResetArms(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().resetArms();
        }

        public void clickMovementLeftArmUp(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveArmUp(true,-0.4f);
        }

        public void clickMovementLeftArmDown(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveArmUp(true,0.4f);
        }

        public void clickMovementLeftArmLeft(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveArmRight(true,0.4f);
        }

        public void clickMovementLeftArmRight(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveArmRight(true,-0.4f);
        }

        public void clickMovementRightArmUp(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveArmUp(false,-0.4f);
        }

        public void clickMovementRightArmDown(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveArmUp(false,0.4f);
        }

        public void clickMovementRightArmLeft(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveArmRight(false,0.4f);
        }

        public void clickMovementRightArmRight(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getMovement().moveArmRight(false,-0.4f);
        }


        // Appearance
        public void clickAppearanceButtonReset(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getAppearance().resetLEDs();
        }

        public void clickAppearanceButtonSet(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getAppearance().changeLEDColor();
        }

        public void changeAppearanceGroup(ActionEvent actionEvent) {
            connection.getAppearance().setGroup(AppearanceComboBoxGroup.getSelectionModel().getSelectedItem().toString());
        }

        public void changeAppearanceColor(ActionEvent actionEvent) {
            connection.getAppearance().setColor(AppearanceComboBoxColor.getSelectionModel().getSelectedItem().toString());
        }


        // BodyState
        public void clickBodyStateButton(ActionEvent actionEvent) throws InterruptedException, CallError {
            // get battery percentage
            String BatteryPercentage;
            BatteryPercentage = connection.getBodyState().getBatteryPercentage()+" %";
            changeLabelText(BodyStateBatteryPercentage, BatteryPercentage);

            // get temperature
            String Temp;
            Temp = connection.getBodyState().getTemperature();
            changeLabelText(BodyStateLabelTemp,Temp);
        }


        // HeadAlignment
        public void clickHeadAlButtonUp(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getHeadAlignment().moveHeadUp();
        }

        public void clickHeadAlButtonDown(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getHeadAlignment().moveHeadDown();
        }

        public void clickHeadAlButtonCenter(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getHeadAlignment().moveHeadCenter();
        }

        public void clickHeadAlButtonLeft(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getHeadAlignment().moveHeadLeft();
        }

        public void clickHeadAlButtonRight(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getHeadAlignment().moveHeadRight();
        }


        // Behavior
        public void clickBehaviorButtonStart(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getBehavior().startBehavior();
        }

        public void clickBehaviorButtonStop(ActionEvent actionEvent) throws CallError, InterruptedException {
            connection.getBehavior().stopBehavior();
        }

        public void changeBehaviorName(ActionEvent actionEvent) {
            connection.getBehavior().setBehaviorName(BehaviorComboBox.getSelectionModel().getSelectedItem().toString());
        }

}