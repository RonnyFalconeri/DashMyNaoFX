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
// 1.0f nach unten -1.0f nach oben HeadPitch 0.0f
//1.0f nach links -1.0 nach rechts für Center 0.0f
// motion = new ALMotion(app.session());
//System.out.println(motion.getSummary());
//motion.angleInterpolationWithSpeed("HeadPitch",1.0f, 0.50f);
//motion.angleInterpolationWithSpeed("HeadPitch",0.0f, 0.50f);
//motion.angleInterpolationWithSpeed("HeadYaw",0.0f, 0.50f);
// motion.angleInterpolationWithSpeed("HeadYaw",1.0f, 0.5f);