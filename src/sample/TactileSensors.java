package sample;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.*;

public class TactileSensors {

    // variables of instance
    private long frontTactilSubscriptionId;
    private long rearTactilSubscriptionId;
    private long middleTactilSubscriptionId;

    // variables of other objects
    private Connection Con;
    private ALSensors sensors;
    private ALMemory memory;



        // Constructor
        public TactileSensors(Connection pCon) throws Exception {
            this.Con = pCon;
            memory = new ALMemory(Con.getSession());

            rearTactilSubscriptionId = memory.subscribeToEvent("RearTactilTouched", new EventCallback<Float>() {
                        @Override
                        public void onEvent(Float arg0)
                                throws InterruptedException, CallError {
                            if (arg0 > 0) {
                                if (rearTactilSubscriptionId > 0) {
                                    System.out.println("pressed");
                                    try {
                                        Con.getSpeech().sayText("back","English");
                                        //Con.getSpeech().sayText("English motherfucker","English",120);
                                        //Con.getSpeech().sayText("Do you speak it!","English", 10);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });

            frontTactilSubscriptionId = memory.subscribeToEvent("FrontTactilTouched", new EventCallback<Float>() {
                        @Override
                        public void onEvent(Float arg0)
                                throws InterruptedException, CallError {
                            if (arg0 > 0) {
                                if (frontTactilSubscriptionId > 0) {
                                    System.out.println("pressed");
                                    try {
                                        Con.getSpeech().sayText("front","English");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });

            middleTactilSubscriptionId = memory.subscribeToEvent("MiddleTactilTouched", new EventCallback<Float>() {
                        @Override
                        public void onEvent(Float arg0)
                                throws InterruptedException, CallError {
                            if (arg0 > 0) {
                                if (middleTactilSubscriptionId > 0) {
                                    System.out.println("pressed");
                                    try {
                                        Con.getSpeech().sayText("middle","English");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });

        }
}
