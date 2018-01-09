package sample;

public class Movement {
    protected int X_Axis;
    protected int Y_Axis;
    protected int Velocity;

    public Movement(int pX_Axis, int pY_Axis, int pVelocity){
        System.out.println("new Movement()...");

        this.X_Axis = pX_Axis;
        this.Y_Axis = pY_Axis;
        this.Velocity = pVelocity;
    }

    private void moveBody(){
        System.out.println("Starting parameters for body movement: ("+this.X_Axis+", "+this.Y_Axis+") at "+this.Velocity+" m/s.");

        // TODO: make the body move at given parameters
    }

    private void moveHead(){
        System.out.println("Starting parameters for head movement: ("+this.X_Axis+", "+this.Y_Axis);

        // TODO: make the head move to given directions
    }
}
