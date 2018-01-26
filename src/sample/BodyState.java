package sample;

public class BodyState {

    private double Temperature;
    private int BatteryPercentage;



    // Constructor
    public BodyState(){
        System.out.println("new BodyState()...");

    }


    // methods for NAO
    public void checkTemperature(){
        System.out.println("checking Temperature...");

        // TODO: check the temperature of the NAO
    }

    public void checkBatteryPercentage(){
        System.out.println("checking BatteryPercentage...");

        // TODO: check the BatteryPercentage of the NAO
    }


    // set n' get
    public double getTemperature(){
        return this.Temperature;
    }

    public int getBatteryPercentage(){
        return this.BatteryPercentage;
    }

}
//battery
//battery = new ALBattery(app.session());
//System.out.println(battery.getBatteryCharge());