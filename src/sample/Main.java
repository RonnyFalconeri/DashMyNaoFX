/*
        DASH MY NAO FX - A JAVA APPLICATION

        Created by: Ronny Falconeri, Marcel Uthe, Niclas Meier
        DHBW Lörrach DE, Feb 2018

 */


package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Dash My Nao FX");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream( "images/icon.png" )));
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }

}

//public static boolean x = true;
//public static boolean aftertrack;
//  tracker = new ALTracker(app.session());
//
//        tracker.stopTracker(); // Tracking auf false setzen
//        tracker.registerTarget("Face", 0.1F);
//        tracker.track("Face"); //PTargets: [RedBall, Face, LandMark, LandMarks, People, Sound]
//        tracker.toggleSearch(true); // sucht nach objekt
//        //tracker.toggleSearch(false); // stoppt suche
//
//        System.out.println(tracker.isActive()); // Tracking: True oder False
//
//       // System.out.println(tracker.getRegisteredTargets()); // Informationen zum Status
//       // System.out.println(tracker.getActiveTarget()); // Informationen zum Status
//
//     while (x == true ) { // Läuft solange bis er target detectected
//         aftertrack = false;
//            aftertrack = tracker.isNewTargetDetected();
//
//       if (aftertrack == true) {
//         tracker.toggleSearch(false); // stoppt kopf Bewegung
//         System.out.println("person detected");
//           tracker.removeAllTargets();
//         x = false;
//       }
//    }
//}
//}