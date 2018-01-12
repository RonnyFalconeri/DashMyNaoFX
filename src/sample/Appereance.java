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
        // TODO: change color of the eye 'whichEye' (left-1, right-2)

    }

    public void changeEyeBlink(int whichEye){
        // TODO: change blinking (on, off) of the eye 'whichEye' (left-1, right-2)
    }


    //set n' get
    public void setEar_Left_LED(int color){
        this.Ear_Left_LED = color;
    }

    public void setEar_Right_LED(int color){
        this.Ear_Right_LED = color;
    }
}
