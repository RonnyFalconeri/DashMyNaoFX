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
        private float MoveUp;
        private float LMoveRight = 0.0f;
        private float RMoveRight = 0.0f;
        private float MoveRight;


    // variables of other objects
    private ALMotion motion;



        // Constructor
        public Movement(Connection pCon) throws Exception {
            motion = new ALMotion(pCon.getSession());
        }



    // methods for NAO

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
            if (pLeftArm){
                increaseUp(true, pMoveUp);
                this.MoveUp = this.LMoveUp;
                Name = "LShoulderPitch";
            } else {
                increaseUp(false, pMoveUp);
                this.MoveUp = this.RMoveUp;
                Name = "RShoulderPitch";
            }

            System.out.println("MoveUp: "+this.MoveUp);
            motion.angleInterpolationWithSpeed(Name, this.MoveUp, 0.20f);
        }

        private void increaseUp(boolean left, float pValue){
            if (left) {
                if (this.LMoveUp+pValue < 2.0f && this.LMoveUp+pValue > -2.3f) {
                    System.out.println(this.LMoveUp + " + " + pValue);
                    this.LMoveUp = this.LMoveUp + pValue;
                }
            } else {
                if (this.RMoveUp+pValue < 2.0f && this.RMoveUp+pValue > -2.3f) {
                    System.out.println(this.RMoveUp + " + " + pValue);
                    this.RMoveUp = this.RMoveUp + pValue;
                }
            }
        }

        public void moveArmRight(boolean pLeftArm, float pMoveRight) throws InterruptedException, CallError {
            String Name;
            if (pLeftArm){
                increaseRight(true, pMoveRight);
                this.MoveRight = this.LMoveRight;
                Name = "LShoulderRoll";
            } else {
                increaseRight(false, pMoveRight);
                this.MoveRight = this.RMoveRight;
                Name = "RShoulderRoll";
            }
            System.out.println("MoveRight: "+this.MoveRight);
            motion.angleInterpolationWithSpeed(Name, this.MoveRight, 0.20f);
        }

        private void increaseRight(boolean left, float pValue){
            if (left) {
                if (this.LMoveRight+pValue < 1.6f && this.LMoveRight+pValue > -0.8f) {
                    System.out.println(this.LMoveRight + " + " + pValue);
                    this.LMoveRight = this.LMoveRight + pValue;
                }
            } else {
                if (this.RMoveRight+pValue < 0.8f && this.RMoveRight+pValue > -1.6f) {
                    System.out.println(this.RMoveRight + " + " + pValue);
                    this.RMoveRight = this.RMoveRight + pValue;
                }
            }
        }

        public void resetArms() throws InterruptedException, CallError {
            System.out.println("reset arm position");
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