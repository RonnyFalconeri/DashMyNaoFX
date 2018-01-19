package sample;

public class Movement {

    private float X_Axis; // forwarth (W), negative value for backwards (S)
    private float Y_Axis; // left (A), negative value for right (D)
    private float Z_Axis; // forward+left (AW), forward+right "-left" (WD), backwards+left "-forward" (AS), backwards+right "-forward+-left" (SD)
    private float Velocity;



    // Constructor
    public Movement(){
        System.out.println("new Movement()...");

    }


    // methods for NAO
    public void moveBody(){
        System.out.println("Starting parameters for body movement: ("+this.X_Axis+", "+this.Y_Axis+") at "+this.Velocity+" m/s.");

        // TODO: make the body move at given parameters
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

    public void setZ_Axis(int pZ_Axis){
        System.out.println("set Z_Axis to: "+pZ_Axis);
        this.Y_Axis = pZ_Axis;
    }

    public void setVelocity(int pVelocity){
        System.out.println("set Velocity to: "+pVelocity);
        this.Velocity = pVelocity;
    }

}