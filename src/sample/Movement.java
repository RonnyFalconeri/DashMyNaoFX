package sample;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALMotion;

public class Movement {

    private float X_Axis=1;
    private float Y_Axis=0;
    private float Velocity=1;

    private ALMotion Motion;


    // Constructor
    public Movement(ALMotion pMotion){
        System.out.println("new Movement()...");
        this.Motion = pMotion;
    }


    // methods for NAO
    public void moveBody() throws InterruptedException, CallError {
        System.out.println("Starting parameters for body movement: ("+this.X_Axis+", "+this.Y_Axis+") at "+this.Velocity+" m/s.");

        // TODO: make the body move at given parameters
        Motion.move(this.X_Axis,this.Y_Axis,this.Velocity);
    }

    public void moveHead(){
        System.out.println("Starting parameters for head movement: ("+this.X_Axis+", "+this.Y_Axis);

        // TODO: make the head move to given directions
    }


    // set n' get
    public void setX_Axis(int pX_Axis){
        System.out.println("set X_Axis to: "+pX_Axis);
        this.X_Axis = pX_Axis;
    }

    public void setY_Axis(int pY_Axis){
        System.out.println("set Y_Axis to: "+pY_Axis);
        this.Y_Axis = pY_Axis;
    }

    public void setVelocity(int pVelocity){
        System.out.println("set Velocity to: "+pVelocity);
        this.Velocity = pVelocity;
    }

}
