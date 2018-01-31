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
            motion = new ALMotion(Con.getApplication().session());
        }



    // methods for NAO
    public void moveHeadUp() throws InterruptedException, CallError {
        System.out.println("moving head up");
        this.Vertical_Axis = 1.0f;
        motion.angleInterpolationWithSpeed("HeadPitch",this.Vertical_Axis, 0.50f);
    }

    public void moveHeadRight() throws InterruptedException, CallError {
        System.out.println("moving head right");
        this.Horizontal_Axis = -1.0f;
        motion.angleInterpolationWithSpeed("HeadPitch",this.Horizontal_Axis, 0.50f);
    }

    public void moveHeadDown() throws InterruptedException, CallError {
        System.out.println("moving head down");
        this.Vertical_Axis = -1.0f;
        motion.angleInterpolationWithSpeed("HeadPitch",this.Vertical_Axis, 0.50f);
    }

    public void moveHeadLeft() throws InterruptedException, CallError {
        System.out.println("moving head left");
        this.Horizontal_Axis = 1.0f;
        motion.angleInterpolationWithSpeed("HeadPitch",this.Horizontal_Axis, 0.50f);
    }

    public void moveHeadCenter() throws InterruptedException, CallError {
        System.out.println("moving head center");
        this.Horizontal_Axis = 0.0f;
        this.Vertical_Axis = 0.0f;
        motion.angleInterpolationWithSpeed("HeadPitch",this.Horizontal_Axis, 0.50f);
        motion.angleInterpolationWithSpeed("HeadPitch",this.Vertical_Axis, 0.50f);
    }

}


// 1.0f nach unten -1.0f nach oben HeadPitch 0.0f
//1.0f nach links -1.0 nach rechts für Center 0.0f
// motion = new ALMotion(app.session());
//System.out.println(motion.getSummary());
//motion.angleInterpolationWithSpeed("HeadPitch",1.0f, 0.50f);
//motion.angleInterpolationWithSpeed("HeadPitch",0.0f, 0.50f);
//motion.angleInterpolationWithSpeed("HeadYaw",0.0f, 0.50f);
// motion.angleInterpolationWithSpeed("HeadYaw",1.0f, 0.5f);