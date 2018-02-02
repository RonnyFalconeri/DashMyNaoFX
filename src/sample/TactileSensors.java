package sample;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.*;

public class TactileSensors {

    private Connection Con;
    private long frontTactilSubscriptionId;

    private ALSensors sensors;
    private ALMemory memory;

    public TactileSensors(Connection pCon) throws Exception {
        System.out.println("new TactileSensors()...");
        this.Con = pCon;
        memory = new ALMemory(Con.getSession());

        frontTactilSubscriptionId = memory.subscribeToEvent(
                        "FrontTactilTouched", new EventCallback<Float>() {
                            @Override
                            public void onEvent(Float para)   throws InterruptedException, CallError {
                                touchedFront();

                                // 1 means the sensor has been pressed
                                if (para > 0) {
                                   if (frontTactilSubscriptionId > 0) {
                                       frontTactilSubscriptionId = 0;
                                        System.out.println("vorne");
                                    }
                                }
                            }

                        });
    }

    private void touchedFront(){
        System.out.println("Frontal sensor touched...");
    }

}
//          public static ALSensors sensors;
//          public static long frontTactilSubscriptionId;
//           memory = new ALMemory(app.session());
//            tts = new ALTextToSpeech(app.session());
//            frontTactilSubscriptionId = 0;
//        x = true;
//          while ( x == true ) {
//                frontTactilSubscriptionId = memory.subscribeToEvent(
//                        "FrontTactilTouched", new EventCallback<Float>() {
//                            @Override
//                            public void onEvent(Float para)   throws InterruptedException, CallError {
//                                // 1 means the sensor has been pressed
//                                if (para > 0) {
//                                   if (frontTactilSubscriptionId > 0) {
//                                       frontTactilSubscriptionId = 0;
//                                        System.out.println("vorne");
//                                        tts.say("middle");
//                                    }
//                                }
//                            }
//
//                        });
//                memory.subscribeToEvent("MiddleTactilTouched",
//                        new EventCallback<Float>() {
//                            @Override
//                            public void onEvent(Float arg0)
//                                    throws InterruptedException, CallError {
//                                if (arg0 > 0) {
//                                    if (frontTactilSubscriptionId > 0) {
//                                        System.out.println("Mittel");
//                                        frontTactilSubscriptionId = 0;
//                                        x = false;
//                                        tts.say("Mittel");
//                                        memory.unsubscribeToEvent(frontTactilSubscriptionId);
//                                    }
//                                }
//                            }
//
//                            });
//
//           }
