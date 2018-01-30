package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALBattery;
import com.aldebaran.qi.helper.proxies.ALBodyTemperature;
import java.util.ArrayList;

public class BodyState {

    private String Temperature;
    private int BatteryPercentage;

    private ALBattery battery;
    private ALBodyTemperature temp;
    private Object tempOb;
    private Connection Con;



        // Constructor
        public BodyState(Connection pCon) throws Exception {
            System.out.println("new BodyState()...");
            this.Con = pCon;
            battery = new ALBattery(Con.getApplication().session());
            temp = new ALBodyTemperature(Con.getApplication().session());
        }



    // methods for NAO
    public void checkTemperature() throws InterruptedException, CallError {
        System.out.println("checking Temperature...");
        tempOb = temp.getTemperatureDiagnosis();
        int Temperatures=5;

        if (tempOb instanceof ArrayList) {
            ArrayList tempList = (ArrayList) tempOb;
            Temperatures = (int) tempList.get(0);
        } else {
            System.out.println("no given return values");
        }

        switch (Temperatures){
            case 0:
                this.Temperature = " Green - Everything is fine.";
            break;
            case 1:
                this.Temperature = "Yellow - Watch out.";
            break;
            case 2:
                this.Temperature = "Red - let the NAO cool down!";
            break;
            default:
                System.out.println("temperature return error");
        }
    }

    public void checkBatteryPercentage() throws InterruptedException, CallError {
        System.out.println("checking battery percentage...");
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