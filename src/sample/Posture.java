package sample;

public class Posture {

    private String Posture;

    public Posture(){
        System.out.println("new Posture()...");

    }

    // methods for NAO
    public void posePosture(){
        System.out.println("posing to: "+this.Posture);

        // TODO: make the NAO pose the given posture
    }

    // set n' get
    public void setPosture(String Posture){
        System.out.println("set Posture to: "+Posture);
        this.Posture = Posture;
    }
}
