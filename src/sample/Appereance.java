package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALLeds;

public class Appereance {

    //allowed colors: "white", "red", "green", "blue", "yellow", "magenta", "cyan"

    private String LeftEar = "LeftEarLeds";
    private String RightEar = "RightEarLeds";

    private boolean BothEyes;
    private String LeftEye = "LeftEye";
    private String RightEye = "RightEye";

    private String LeftEyeColor = "white";
    private String RightEyeColor = "white";
    private float dur = 1.0f;

    private ALLeds leds;
    private Connection Con;

    // colors-string: white, red, green, blue, yellow, magenta, cyan

    // Constructor
    public Appereance(Connection connection) throws Exception {
        System.out.println("new Appereance()...");
        this.Con = connection;

        leds = new ALLeds(Con.getApplication().session());

    }


    // methods for NAO
    public void changeEyeColor(int whichEye) throws InterruptedException, CallError {
        leds.reset("ALLeds");
        switch (whichEye){
            case 0: // left eye
                leds.fadeRGB(this.LeftEye, this.LeftEyeColor, this.dur);
                break;
            case 1: // right eye
                leds.fadeRGB(this.RightEye, this.RightEyeColor, this.dur);
                break;
            case 2: // both eye
                leds.fadeRGB(this.LeftEye, this.LeftEyeColor, this.dur);
                leds.fadeRGB(this.RightEye, this.LeftEyeColor, this.dur);
                break;
            default:
                System.out.println("error");
        }

    }

    public void changeEyeBlink(int whichEye){
        // TODO: change blinking (on, off) of the eye 'whichEye' (left-1, right-2, both-3)
    }


    //set n' get


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
}