package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALMotion;

public class Movement {

    private float X_Axis = 1.0f;
    private float Y_Axis;
    private float Z_Axis;
    private float Velocity = 0.5f;

    private Connection Con;
    private ALMotion motion;



    // Constructor
    public Movement(Connection pConnection) throws Exception {
        System.out.println("new Movement()...");
        this.Con = pConnection;
        motion = new ALMotion(Con.getApplication().session());
    }



    // methods for NAO
    public void moveBodyForward() throws InterruptedException, CallError {
        this.X_Axis = 1.0f*this.Velocity;
        this.Y_Axis = 0.0f;
        this.Z_Axis = 0.0f;
        motion.stopMove();
        motion.moveToward( this.X_Axis, this.Y_Axis, this.Z_Axis);
    }

    public void moveBodyBackwards() throws InterruptedException, CallError {
        this.Y_Axis = 0.0f;
        this.X_Axis = -0.5f;
        this.Z_Axis = 0.0f;
        motion.stopMove();
        motion.moveToward( this.X_Axis, this.Y_Axis, this.Z_Axis);
    }

    public void changeMovementDirectionLeft() throws InterruptedException, CallError {
        this.Y_Axis = 0.0f;
        this.X_Axis = 0.0f;
        this.Z_Axis = 0.30f;
        motion.stopMove();
        motion.moveToward( this.X_Axis, this.Y_Axis, this.Z_Axis);
    }

    public void changeMovementDirectionRight() throws InterruptedException, CallError {
        this.Y_Axis = 0.0f;
        this.X_Axis = 0.0f;
        this.Z_Axis = -0.30f;
        motion.stopMove();
        motion.moveToward( this.X_Axis, this.Y_Axis, this.Z_Axis);
    }

    public void stopMovement() throws InterruptedException, CallError {
        motion.stopMove();
        motion.moveToward( 0.0f,0.0f,0.0f);
    }


    // set n' get
    public void setX_Axis(float pX_Axis){
        System.out.println("set X_Axis to: "+pX_Axis);
        this.X_Axis = pX_Axis;
    }

    public void setVelocity(float pVel) {
        this.Velocity = pVel;
    }

    public void setY_Axis(float pY_Axis){
        System.out.println("set Y_Axis to: "+pY_Axis);
        this.Y_Axis = pY_Axis;
    }

    public void setZ_Axis(float pZ_Axis){
        System.out.println("set Z_Axis to: "+pZ_Axis);
        this.Y_Axis = pZ_Axis;
    }

}

// y wert steht für geschwindigkeit? also doch parameter?
//public static ALMotion motion;

// gerade aus
//public static float x = 1.0f;
//public static float y = 0.0f;
//public static float gerade = 0.0f;

//drehen links
//public static float x1 = 0.0f;
//public static float y1 = 0.0f;
//public static float drehunglinks = -0.50f;

// drehen rechts
//public static float x2 = 0.0f;
//public static float y2 = 0.0f;
//public static float drehungrechts = 0.50f;

//gerade aus
//motion = new ALMotion(app.session());
//motion.stopMove();
//motion.moveToward( x, y, gerade);

// nach links
//motion = new ALMotion(app.session());
//motion.stopMove();
//motion.moveToward( x1, y1, drehunglinks);
// nach rechts

//motion = new ALMotion(app.session());
//motion.stopMove();
//motion.moveToward( x2, y2, drehungrechts);

//stoppen
//motion = new ALMotion(app.session());
// motion.stopMove();