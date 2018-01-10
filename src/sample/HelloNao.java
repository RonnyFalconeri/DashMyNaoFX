import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

public class HelloNao {
    public Application app;

    public static void main(String[] args) throws Exception {
        String robotUrl = "tcp://192.168.1.133:9559";
        app = new Application(args, robotUrl);
        app.start();

        sayHello();
        // ALRobotPosture posture = new ALRobotPosture(application.session());
        // posture.goToPosture("LyingBack", 1.0f);
    }

    public static void sayHello() throws Exception{
        ALTextToSpeech tts = new ALTextToSpeech(app.session());
        tts.say("ich bin verbunden");
    }

}
