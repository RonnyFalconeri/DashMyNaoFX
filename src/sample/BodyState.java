package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALBattery;

public class BodyState {

    private double Temperature;
    private int BatteryPercentage;

    private ALBattery battery;
    private Connection Con;

    // Constructor
    public BodyState(Connection pCon) throws Exception {
        System.out.println("new BodyState()...");
        this.Con = pCon;
        battery = new ALBattery(Con.getApplication().session());
    }


    // methods for NAO
    public void checkTemperature(){
        System.out.println("checking Temperature...");

        // TODO: check the temperature of the NAO
    }

    public void checkBatteryPercentage() throws InterruptedException, CallError {
        System.out.println("checking BatteryPercentage...");
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