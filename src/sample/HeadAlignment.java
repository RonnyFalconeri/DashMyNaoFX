package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALMotion;

public class HeadAlignment {

    // variables of instance
    private double Vertical_Axis; //HeadPitch
    private double Horizontal_Axis; //HeadYaw

    // variables of other objects
    private Connection Con;
    private ALMotion motion;



        // Constructor
        public HeadAlignment(Connection pCon) throws Exception {
            System.out.println("new HeadAlignment()...");
            this.Con = pCon;
            motion = new ALMotion(this.Con.getSession());
        }



    // methods for NAO
    public void moveHeadUp() throws InterruptedException, CallError {
        System.out.println("moving head up");
        this.Vertical_Axis = -1.0f;
        motion.angleInterpolationWithSpeed("HeadPitch",this.Vertical_Axis, 0.20f);
    }

    public void moveHeadRight() throws InterruptedException, CallError {
        System.out.println("moving head right");
        this.Horizontal_Axis = -1.0f;
        motion.angleInterpolationWithSpeed("HeadYaw",this.Horizontal_Axis, 0.20f);
    }

    public void moveHeadDown() throws InterruptedException, CallError {
        System.out.println("moving head down");
        this.Vertical_Axis = 1.0f;
        motion.angleInterpolationWithSpeed("HeadPitch",this.Vertical_Axis, 0.20f);
    }

    public void moveHeadLeft() throws InterruptedException, CallError {
        System.out.println("moving head left");
        this.Horizontal_Axis = 1.0f;
        motion.angleInterpolationWithSpeed("HeadYaw",this.Horizontal_Axis, 0.20f);
    }

    public void moveHeadCenter() throws InterruptedException, CallError {
        System.out.println("moving head center");
        this.Horizontal_Axis = 0.0f;
        this.Vertical_Axis = 0.0f;
        motion.angleInterpolationWithSpeed("HeadYaw",this.Horizontal_Axis, 0.20f);
        motion.angleInterpolationWithSpeed("HeadPitch",this.Vertical_Axis, 0.20f);
    }

}
