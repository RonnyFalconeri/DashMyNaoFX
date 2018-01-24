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

// y wert steht für geschwindigkeit? also doch parameter?
//public static ALMotion motion;

// gerade aus
//public static float x = 1.0f;
//public static float y = 0.0f;
//public static float gerade = 0.0f;

//drehen links
//public static float x1 = 0.0f;
//public static float y1 = 0.0f;
//public static float drehunglinks = -0.50f;

// drehen rechts
//public static float x2 = 0.0f;
//public static float y2 = 0.0f;
//public static float drehungrechts = 0.50f;

//gerade aus
//motion = new ALMotion(app.session());
//motion.stopMove();
//motion.moveToward( x, y, gerade);

// nach links
//motion = new ALMotion(app.session());
//motion.stopMove();
//motion.moveToward( x1, y1, drehunglinks);
// nach rechts

//motion = new ALMotion(app.session());
//motion.stopMove();
//motion.moveToward( x2, y2, drehungrechts);

//stoppen
//motion = new ALMotion(app.session());
// motion.stopMove();