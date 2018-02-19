package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALBattery;
import com.aldebaran.qi.helper.proxies.ALBodyTemperature;
import java.util.ArrayList;

public class BodyState {

    // variables of instance
    private String Temperature;
    private int BatteryPercentage;

    // variables of other objects
    private ALBattery battery;
    private ALBodyTemperature temp;



        // Constructor
        BodyState(Connection pCon) throws Exception {
            battery = new ALBattery(pCon.getSession());
            temp = new ALBodyTemperature(pCon.getSession());
        }



    // methods for NAO
    private void checkTemperature() throws InterruptedException, CallError {
        Object tempOb = temp.getTemperatureDiagnosis();
        int tempReturn=0;

        if (tempOb instanceof ArrayList) {
            ArrayList tempList = (ArrayList) tempOb;
            tempReturn = (int) tempList.get(0);
        }

        switch (tempReturn){
            case 0:
                this.Temperature = "Everything is fine.";
            break;
            case 1:
                this.Temperature = "Watch out.";
            break;
            case 2:
                this.Temperature = "let the NAO cool down!";
            break;
            default:
                this.Temperature = "No value given.";
        }
    }

    private void checkBatteryPercentage() throws InterruptedException, CallError {
        this.BatteryPercentage = battery.getBatteryCharge();
    }


    // set n' get
    public String getTemperature() throws CallError, InterruptedException {
        checkTemperature();
        return this.Temperature;
    }

    public int getBatteryPercentage() throws CallError, InterruptedException {
        checkBatteryPercentage();
        return this.BatteryPercentage;
    }

}