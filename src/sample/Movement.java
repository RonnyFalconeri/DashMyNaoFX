package sample;

public class Movement {

    private int X_Axis;
    private int Y_Axis;
    private int Velocity;



    // Constructor
    public Movement(){
        System.out.println("new Movement()...");
    }


    // methods for NAO
    public void moveBody(){
        System.out.println("Starting parameters for body movement: ("+this.X_Axis+", "+this.Y_Axis+") at "+this.Velocity+" m/s.");

        // TODO: make the body move at given parameters
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