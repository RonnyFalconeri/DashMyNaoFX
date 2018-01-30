package sample;

public class HeadAlignment {

    private double X_Axis;
    private double Y_Axis;
    private double Z_Axis;

    private Connection Con;



        // Constructor
        public HeadAlignment(Connection pCon){
            System.out.println("new HeadAlignment()...");
            this.Con = pCon;
        }



    // methods for NAO
    public void moveHeadUp(){
        System.out.println("moving head up");

        // TODO: make the head move with the given parameters
    }

    public void moveHeadRight(){
        System.out.println("moving head right");

        // TODO: make the head move with the given parameters
    }

    public void moveHeadDown(){
        System.out.println("moving head down");

        // TODO: make the head move with the given parameters
    }

    public void moveHeadLeft(){
        System.out.println("moving head left");

        // TODO: make the head move with the given parameters
    }

    public void moveHeadCenter(){
        System.out.println("moving head center");

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
