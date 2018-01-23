package sample;

import com.aldebaran.qi.helper.proxies.ALLeds;

public class Appereance {
    private String All = "ALLeds";

    private boolean Both_Ears_LED;
    private String Ear_Left_LED = "gg";
    private int Ear_Right_LED;

    private boolean Both_Eyes_LED;
    private int Eye_Left_LED;
    private int Eye_Right_LED;

    private boolean Both_Eyes_Blink;
    private boolean Eye_Left_Blink;
    private boolean Eye_Right_Blink;
    private int Blink_Rate;

    ALLeds leds;
    private Connection Con;

    // colors-string: white, red, green, blue, yellow, magenta, cyan

    // Constructor
    public Appereance(Connection connection) throws Exception {
        System.out.println("new Appereance()...");
        this.Con = connection;

        leds = new ALLeds(Con.getApplication().session());

        //reset
        leds.reset("ALLeds");

        //fade
        leds.fadeRGB("ALLeds", "red", 10.0f);

    }


    // methods for NAO
    public void changeEyeColor(int whichEye){
        // TODO: change color of the eye 'whichEye' (left-1, right-2, both-3)

    }

    public void changeEyeBlink(int whichEye){
        // TODO: change blinking (on, off) of the eye 'whichEye' (left-1, right-2, both-3)
    }


    //set n' get


    public void setEar_Right_LED(int color){
        this.Ear_Right_LED = color;
    }
}