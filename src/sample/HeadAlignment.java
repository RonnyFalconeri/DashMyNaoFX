package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALMotion;

public class HeadAlignment {

    // variables of instance
    private double Vertical_Axis;
    private double Horizontal_Axis;

    // variables of other objects
    private ALMotion motion;



        // Constructor
        HeadAlignment(Connection pCon) throws Exception {
            motion = new ALMotion(pCon.getSession());
        }



    // methods for NAO
    public void moveHeadUp() throws InterruptedException, CallError {
        this.Vertical_Axis = -1.0f;
        motion.angleInterpolationWithSpeed("HeadPitch",this.Vertical_Axis, 0.20f);
    }

    public void moveHeadRight() throws InterruptedException, CallError {
        this.Horizontal_Axis = -1.0f;
        motion.angleInterpolationWithSpeed("HeadYaw",this.Horizontal_Axis, 0.20f);
    }

    public void moveHeadDown() throws InterruptedException, CallError {
        this.Vertical_Axis = 1.0f;
        motion.angleInterpolationWithSpeed("HeadPitch",this.Vertical_Axis, 0.20f);
    }

    public void moveHeadLeft() throws InterruptedException, CallError {
        this.Horizontal_Axis = 1.0f;
        motion.angleInterpolationWithSpeed("HeadYaw",this.Horizontal_Axis, 0.20f);
    }

    public void moveHeadCenter() throws InterruptedException, CallError {
        this.Horizontal_Axis = 0.0f;
        this.Vertical_Axis = 0.0f;
        motion.angleInterpolationWithSpeed("HeadYaw",this.Horizontal_Axis, 0.20f);
        motion.angleInterpolationWithSpeed("HeadPitch",this.Vertical_Axis, 0.20f);
    }

}
