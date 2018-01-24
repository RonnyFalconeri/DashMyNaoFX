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
        System.out.println("changing LED colors..."+this.Group+", "+this.Color);
        leds.reset("AllLeds");
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


////////////////////////////////////////////////////////////////////////

    //[AllLeds,
    // AllLedsBlue
    // AllLedsGreen,
    // AllLedsRed,
    // BrainLeds,
    // BrainLedsBack,
    // BrainLedsFront,
    // BrainLedsLeft,
    // BrainLedsMiddle,
    // BrainLedsRight,
    // ChestLeds,
    // EarLeds,
    // FaceLed0,
    // FaceLed1,
    // FaceLed2,
    // FaceLed3,
    // FaceLed4,
    // FaceLed5,
    // FaceLed6,
    // FaceLed7,
    // FaceLedLeft0,
    // FaceLedLeft1,
    // FaceLedLeft2,
    // FaceLedLeft3,
    // FaceLedLeft4,
    // FaceLedLeft5,
    // FaceLedLeft6,
    // FaceLedLeft7,
    // FaceLedRight0,
    // FaceLedRight1,
    // FaceLedRight2,
    // FaceLedRight3,
    // FaceLedRight4,
    // FaceLedRight5,
    // FaceLedRight6,
    // FaceLedRight7,
    // FaceLeds,
    // FaceLedsBottom,
    // FaceLedsExternal,
    // FaceLedsInternal,
    // FaceLedsLeftBottom,
    // FaceLedsLeftExternal,
    // FaceLedsLeftInternal,
    // FaceLedsLeftTop,
    // FaceLedsRightBottom,
    // FaceLedsRightExternal,
    // FaceLedsRightInternal,
    // FaceLedsRightTop,
    // FaceLedsTop,
    // FeetLeds,
    // LeftEarLeds,
    // LeftEarLedsBack,
    // LeftEarLedsEven,
    // LeftEarLedsFront,
    // LeftEarLedsOdd,


    // LeftEarLeds,
    // RightEarLeds,

    // RightEye,
    // LeftEye,

    // RightFootLeds
    // LeftFootLeds,

    //leds.reset("AllLeds");
    //leds.fadeRGB(name, colorname, duration);
