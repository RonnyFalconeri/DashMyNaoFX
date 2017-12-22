package sample;

public class GUI {

    public GUI(){
        System.out.println("new Classes.GUI()...");

        testLogIn();

        testMenu();

    }

    //testing methods
    private void testLogIn(){
        System.out.println("\n**** WILLKOMMEN IM LOGIN ****\n");

        String a = EingabeString("Username: ");
        String b = EingabeString("Password: ");
        String c = EingabeString("IP-Adress: ");
        String d = EingabeString("Port: ");

        LogIn logIn = new LogIn(c, d);
    }

    private void testMenu(){
        System.out.println("\n**** WILLKOMMEN IM Menü ******");
        System.out.println("* 1. Bewegung                *");
        System.out.println("* 2. Sprachausgabe           *");
        System.out.println("* 3. Erscheinung             *");
        System.out.println("* 4. Extras                  *");
        System.out.println("*                            *");
        System.out.println("* 0. Beenden                 *");
        System.out.println("******************************");

        int Eingabe = EingabeInt("Ihre Auswahl: ");

        switch (Eingabe){
            case 1:
                testMovement();
                break;
            case 2:
                // open Speech
                break;
            case 3:
                // open Appearance
                break;
            case 4:
                // open Extras
                break;
            case 0:
                // open Extras
                break;
        }
    }

    private void testMovement(){
        System.out.println("\n**** BEWEGUNG ****\n");

        int x = EingabeInt("X-Achse: ");
        int y = EingabeInt("Y-Achse: ");
        int v = EingabeInt("Geschwindigkeit in m/s: ");
        boolean move = EingabeBoolean("Bewegen? Ja->true | Nein->false: ");
        boolean movehead = EingabeBoolean("Kopf bewegen? Ja->true | Nein->false: ");

        Movement movement = new Movement(x,y,v,move,movehead);
    }


    private boolean EingabeBoolean(String Eingabetext){
        boolean Eingabe;
        System.out.print(Eingabetext);
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Eingabe = scanner.nextBoolean();
        return Eingabe;
    }

    private int EingabeInt(String Eingabetext){
        int Eingabe;
        System.out.print(Eingabetext);
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Eingabe = scanner.nextInt();
        return Eingabe;
    }

    private String EingabeString(String Eingabetext){
        String Eingabe;
        System.out.print(Eingabetext);
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Eingabe = scanner.next();
        return Eingabe;
    }
}
