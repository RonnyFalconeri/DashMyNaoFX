package sample;

public class HeadAlignment {

    private double X_Axis;
    private double Y_Axis;
    private double Z_Axis;



        // Constructor
        public HeadAlignment(){
            System.out.println("new HeadAlignment()...");

        }



    // methods for NAO
    public void moveHead(double X_Axis, double Y_Axis, double Z_Axis){
        System.out.println("moving head to: ("+X_Axis + Y_Axis + Z_Axis+")");

        // TODO: make the head move with the given parameters
    }


    // set n' get
    public void setX_Axis(double x_Axis) {
        X_Axis = x_Axis;
    }

    public void setY_Axis(double y_Axis) {
        Y_Axis = y_Axis;
    }

    public void setZ_Axis(double z_Axis) {
        Z_Axis = z_Axis;
    }
}
