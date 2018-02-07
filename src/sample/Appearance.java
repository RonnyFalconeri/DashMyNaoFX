package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALLeds;

public class Appearance {

    // variables of instance
    private String Color = "white";
    private String Group = "AllLeds";

    // variables of other objects
    private ALLeds LED;



        // Constructor
        Appearance(Connection pCon) throws Exception {
            LED = new ALLeds(pCon.getSession());
        }



    // methods for NAO
    public void changeLEDColor() throws InterruptedException, CallError {
        LED.fadeRGB(this.Group, this.Color, 2.0f);
    }

    public void resetLEDs() throws InterruptedException, CallError {
        LED.reset("AllLeds");
    }


    //set n' get
    public void setGroup(String pGroup){
        this.Group = pGroup;
    }

    public void setColor(String pColor){
        this.Color = pColor;
    }
}
