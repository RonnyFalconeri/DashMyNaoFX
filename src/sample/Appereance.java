package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALLeds;

public class Appereance {

    //allowed colors: "white", "red", "green", "blue", "yellow", "magenta", "cyan"
    private String Color = "white";
    private String Group = "ALLeds";
    private float dur = 2.0f;

    private ALLeds leds;
    private Connection Con;



    // Constructor
    public Appereance(Connection connection) throws Exception {
        System.out.println("new Appereance()...");
        this.Con = connection;
        leds = new ALLeds(Con.getApplication().session());
    }



    // methods for NAO
    public void changeLEDColor() throws InterruptedException, CallError {
        System.out.println("changing LED colors...");
        leds.fadeRGB(this.Group, this.Color, this.dur);
    }

    public void resetLEDs() throws InterruptedException, CallError {
        System.out.println("reseting LED colors...");
        leds.reset("AllLeds");
    }



    //set n' get
    public void setGroup(String pGroup){
        System.out.println("set Group to: "+pGroup);
        this.Group = pGroup;
    }

    public void setColor(String pColor){
        System.out.println("set Color to: "+pColor);
        this.Color = pColor;
    }
}
