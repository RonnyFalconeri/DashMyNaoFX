package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALBattery;
import com.aldebaran.qi.helper.proxies.ALBodyTemperature;

import java.util.ArrayList;

public class BodyState {

    private double Temperature;
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

        /*
        tempOb = temp.getTemperatureDiagnosis();
        if (tempOb instanceof ArrayList) {
            ArrayList tempList = (ArrayList) tempOb;
            System.out.println("Temp level: " + tempList.get(0));
        } else {
            System.out.println("Dieser NAO liefert noch keine Temperaturangaben");
        }
        */
    }

    public void checkBatteryPercentage() throws InterruptedException, CallError {
        System.out.println("checking battery percentage...");
        this.BatteryPercentage = battery.getBatteryCharge();
    }


    // set n' get
    public double getTemperature(){
        return this.Temperature;
    }

    public int getBatteryPercentage() throws CallError, InterruptedException {
        checkBatteryPercentage();
        return this.BatteryPercentage;
    }

}