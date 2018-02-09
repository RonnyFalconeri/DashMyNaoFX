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
        private float MoveUp; // -MoveUp for down
        private float MoveRight; // -MoveRight for left
        //private boolean LeftArm;


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
            System.out.println("moving left arm?: "+pLeftArm);
            System.out.println("Up: "+pMoveUp);
            String Name;
            if (pLeftArm){
                Name = "LeftArmVertikal"; // TODO: change to right name
            } else {
                Name = "RightArmVertikal"; // TODO: change to right name
            }
            motion.angleInterpolationWithSpeed(Name, pMoveUp, 0.20f);
            //TODO: let the arm move at given parameters
        }

        public void moveArmRight(boolean pLeftArm, float pMoveRight) throws InterruptedException, CallError {
            System.out.println("moving left arm?: "+pLeftArm);
            System.out.println("Right: "+pMoveRight);
            String Name;
            if (pLeftArm){
                Name = "LeftArmHorizontal"; // TODO: change to right name
            } else {
                Name = "RightArmHorizontal"; // TODO: change to right name
            }
            motion.angleInterpolationWithSpeed(Name, pMoveRight, 0.20f);
            //TODO: let the arm move at given parameters
        }

        public void resetArms() throws InterruptedException, CallError {
            System.out.println("reset arm position");
            // TODO: reset arms
            motion.angleInterpolationWithSpeed("LeftArmHorizontal", 0.0f, 0.2f);
            motion.angleInterpolationWithSpeed("RightArmHorizontal", 0.0f, 0.2f);
            motion.angleInterpolationWithSpeed("LeftArmVertikal", 0.0f, 0.2f);
            motion.angleInterpolationWithSpeed("RightArmHorizontal", 0.0f, 0.2f);
        }


    // set n' get
    public void setVelocity(float pVelocity) {
        this.Velocity = pVelocity;
    }

}

//motion = new ALMotion(app.session());
//System.out.println(motion.getSummary());
//motion.angleInterpolationWithSpeed("LShoulderRoll",0.0f, 0.5f); // 1 nach aussen schultermuskel
//motion.angleInterpolationWithSpeed("RShoulderRoll",0.0f, 0.5f); // 1 nach aussen schultermuskel
//motion.angleInterpolationWithSpeed("LShoulderPitch",-1.0f, 0.5f); //arm hoch bei -1.0f brustmuskel
//motion.angleInterpolationWithSpeed("RShoulderPitch",-1.0f, 0.5f); //arm hoch bei -1.0f brustmuskel