package sample;

public class HeadAlignment {

    // variables of instance
    private double Vertical_Axis; //HeadYaw
    private double Horizontal_Axis; //Pitch

    // variables of other objects
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

}
