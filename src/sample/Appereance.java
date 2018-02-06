package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALLeds;

public class Appereance {

    // variables of instance
    private String Color = "white";
    private String Group = "AllLeds";

    // variables of other objects
    private ALLeds leds;



        // Constructor
        public Appereance(Connection pCon) throws Exception {
            leds = new ALLeds(pCon.getSession());
        }



    // methods for NAO
    public void changeLEDColor() throws InterruptedException, CallError {
        leds.fadeRGB(this.Group, this.Color, 2.0f);
    }

    public void resetLEDs() throws InterruptedException, CallError {
        leds.reset("AllLeds");
    }


    //set n' get
    public void setGroup(String pGroup){
        this.Group = pGroup;
    }

    public void setColor(String pColor){
        this.Color = pColor;
    }
}
