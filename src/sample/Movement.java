package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALMotion;

public class Movement {

    // variables of instance

    // walking
    private float X_Axis = 1.0f;
    private float Y_Axis;
    private float Z_Axis;
    private float Velocity = 1.0f;

    // arm motion
    private float LMoveUp = 1.4f;
    private float RMoveUp = 1.4f;
    private float LMoveRight = 0.0f;
    private float RMoveRight = 0.0f;


    // variables of other objects
    private ALMotion motion;



        // Constructor
        public Movement(Connection pCon) throws Exception {
            motion = new ALMotion(pCon.getSession());
        }



    // methods for NAO
    public void changeMode(boolean isActive) throws InterruptedException, CallError {
        if (isActive){
            motion.rest();
        } else {
            motion.wakeUp();
        }
    }

    // walking
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

    // arm motion
    public void moveArmUp(boolean pLeftArm, float pMoveUp) throws InterruptedException, CallError {
        String Name;
        float moveUp;
        if (pLeftArm){
            // move left arm
            increaseUp(true, pMoveUp);
            moveUp = this.LMoveUp;
            Name = "LShoulderPitch";
        } else {
            // move right arm
            increaseUp(false, pMoveUp);
            moveUp = this.RMoveUp;
            Name = "RShoulderPitch";
        }
        motion.angleInterpolationWithSpeed(Name, moveUp, 0.20f);
    }

    private void increaseUp(boolean left, float pValue){
        if (left) {
            // move left arm
            if (this.LMoveUp+pValue < 2.0f && this.LMoveUp+pValue > -2.3f) {
                this.LMoveUp = this.LMoveUp + pValue;
            }
        } else {
            // move right arm
            if (this.RMoveUp+pValue < 2.0f && this.RMoveUp+pValue > -2.3f) {
                this.RMoveUp = this.RMoveUp + pValue;
            }
        }
    }

    public void moveArmRight(boolean pLeftArm, float pMoveRight) throws InterruptedException, CallError {
        String Name;
        float moveRight;
        if (pLeftArm){
            // move left arm
            increaseRight(true, pMoveRight);
            moveRight = this.LMoveRight;
            Name = "LShoulderRoll";
        } else {
            // move right arm
            increaseRight(false, pMoveRight);
            moveRight = this.RMoveRight;
            Name = "RShoulderRoll";
        }
        motion.angleInterpolationWithSpeed(Name, moveRight, 0.20f);
    }

    private void increaseRight(boolean left, float pValue){
        if (left) {
            // move left arm
            if (this.LMoveRight+pValue < 1.6f && this.LMoveRight+pValue > -0.8f) {
                this.LMoveRight = this.LMoveRight + pValue;
            }
        } else {
            // move right arm
            if (this.RMoveRight+pValue < 0.8f && this.RMoveRight+pValue > -1.6f) {
                this.RMoveRight = this.RMoveRight + pValue;
            }
        }
    }

    public void resetArms() throws InterruptedException, CallError {
        motion.angleInterpolationWithSpeed("LShoulderRoll", 0.0f, 0.2f);
        motion.angleInterpolationWithSpeed("RShoulderRoll", 0.0f, 0.2f);
        motion.angleInterpolationWithSpeed("LShoulderPitch", 1.5f, 0.2f);
        motion.angleInterpolationWithSpeed("RShoulderPitch", 1.5f, 0.2f);
    }


    // set n' get
    public void setVelocity(float pVelocity) {
        this.Velocity = pVelocity;
    }

}