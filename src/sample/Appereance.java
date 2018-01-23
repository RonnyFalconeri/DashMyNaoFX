package sample;

public class Appereance {
    private boolean Both_Ears_LED;
    private int Ear_Left_LED;
    private int Ear_Right_LED;

    private boolean Both_Eyes_LED;
    private int Eye_Left_LED;
    private int Eye_Right_LED;

    private boolean Both_Eyes_Blink;
    private boolean Eye_Left_Blink;
    private boolean Eye_Right_Blink;
    private int Blink_Rate;



    // Constructor
    public Appereance(){
        System.out.println("new Appereance()...");

    }


    // methods for NAO
    public void changeEyeColor(int whichEye){
        // TODO: change color of the eye 'whichEye' (left-1, right-2, both-3)

    }

    public void changeEyeBlink(int whichEye){
        // TODO: change blinking (on, off) of the eye 'whichEye' (left-1, right-2, both-3)
    }


    //set n' get
    public void setEar_Left_LED(int color){
        this.Ear_Left_LED = color;
    }

    public void setEar_Right_LED(int color){
        this.Ear_Right_LED = color;
    }

////////////////////////////////////////////////////////////////////////
    // public static ALLeds leds;
    //leds
    //public static String name = "AllLeds";
    //public static String colorname = "red";
    //public static float duration = 5.0f;


    //"white", "red", "green", "blue", "yellow", "magenta", "cyan"
    //[AllLeds, AllLedsBlue, AllLedsGreen, AllLedsRed, BrainLeds, BrainLedsBack, BrainLedsFront, BrainLedsLeft, BrainLedsMiddle, BrainLedsRight, ChestLeds, EarLeds, FaceLed0, FaceLed1, FaceLed2, FaceLed3, FaceLed4, FaceLed5, FaceLed6, FaceLed7, FaceLedLeft0, FaceLedLeft1, FaceLedLeft2, FaceLedLeft3, FaceLedLeft4, FaceLedLeft5, FaceLedLeft6, FaceLedLeft7, FaceLedRight0, FaceLedRight1, FaceLedRight2, FaceLedRight3, FaceLedRight4, FaceLedRight5, FaceLedRight6, FaceLedRight7, FaceLeds, FaceLedsBottom, FaceLedsExternal, FaceLedsInternal, FaceLedsLeftBottom, FaceLedsLeftExternal, FaceLedsLeftInternal, FaceLedsLeftTop, FaceLedsRightBottom, FaceLedsRightExternal, FaceLedsRightInternal, FaceLedsRightTop, FaceLedsTop, FeetLeds, LeftEarLeds, LeftEarLedsBack, LeftEarLedsEven, LeftEarLedsFront, LeftEarLedsOdd, LeftEye, LeftFaceLeds, LeftFaceLedsBlue, LeftFaceLedsGreen, LeftFaceLedsRed, LeftFootLeds, RightEarLeds, RightEarLedsBack, RightEarLedsEven, RightEarLedsFront, RightEarLedsOdd, RightEye, RightFaceLeds, RightFaceLedsBlue, RightFaceLedsGreen, RightFaceLedsRed, RightFootLeds

    //leds = new ALLeds(app.session());
    //System.out.println(leds.listGroups());
    //leds.reset("AllLeds");
    //leds.fadeRGB(name, colorname, duration);
}