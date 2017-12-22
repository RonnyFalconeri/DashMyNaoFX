package sample;

public class Movement {
    private int X_Axis;
    private int Y_Axis;
    private int Velocity;

    private boolean Moving; // switch to turn movement on and off
    private boolean MovingHead=true; //switch mode to move either head or body, true->Head | false->Body

    public Movement(int pX_Axis, int pY_Axis, int pVelocity, boolean pMoving, boolean pMovingHead){
        System.out.println("new Movement()...");

        this.X_Axis = pX_Axis;
        this.Y_Axis = pY_Axis;
        this.Velocity = pVelocity;
        this.Moving = pMoving;
        this.MovingHead = pMovingHead;

        move();
    }

    private void move(){
        System.out.println("start moving to ("+this.X_Axis+", "+this.Y_Axis+") at "+this.Velocity+" m/s. Moving: "+this.Moving+", Moving Head: "+this.MovingHead);

        // TODO: check the moving state and the movinghead state and move with the given parameters
    }
}
