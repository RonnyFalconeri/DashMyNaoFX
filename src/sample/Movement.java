package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALMotion;

public class Movement {

    // variables of instance
    private float X_Axis = 1.0f;
    private float Y_Axis;
    private float Z_Axis;
    private float Velocity = 1.0f;

    // variables of other objects
    private ALMotion motion;



        // Constructor
        public Movement(Connection pCon) throws Exception {
            motion = new ALMotion(pCon.getSession());
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
    public void setVelocity(float pVel) {
        this.Velocity = pVel;
    }

}