package thecode;

import java.util.Scanner;

/**
 * Little Java program made for fun, because I wanted to think about how a door which has to be unlocked with a "passcode" works (even if it's a bit obvious).
 * @author dowymn
 */
public class DoorCode {


    //---[ ATTRIBUTES

    private final Scanner scan = new Scanner(System.in);
    private final String code;


    //---[ CONSTRUCTOR

    /**
     * Constructor of the DoorCode class. Initializes the code of the door.
     * @param code the code needed to unlock the door
     */
    public DoorCode ( String code ) {
        if ( code == null ) {
            this.code = "";
        } else {
            this.code = code;
        }
    }


    //---[ GETTERS / SETTERS

    /**
     * Gets the code of the door.
     * @return the String chains which contains the door
     */
    protected String getCode () {
        return this.code;
    }


    //---[ METHODS

    /**
     * Asks the user to type the door's code in order to unlock it.
     * @return a String chain containing what typed the user
     */
    private String typeFullCode () {
        return scan.nextLine();
    }

    /**
     * Asks the user to type the door's code in order to unlock it.
     * @return the caracter typed by the user
     */
    private char typeChar () {
        return scan.nextLine().charAt(0);
    }

    /**
     * Checks if the typed code if good in real time.
     */
    public void typeCheckCode () {
        boolean found = false;
        boolean wrong = false;
        char carac = '-';

        System.out.println("Saisissez le code en appuyant sur la touche \"Entrée\" après chaque aractère.");
        System.out.println("La saisie se termine une fois que le code correct complet a été entré.");
        System.out.println("Si vous souhaitez arrêter la saisie, entrez \"#\".");
        while ( found == false && carac != '#' ) {
            int i = 1;
            carac = typeChar();

            if ( carac == this.code.charAt(0) ) {
                found = true;
                while ( i < this.code.length() && found == true ) {
                    carac = typeChar();
                    if ( carac == this.code.charAt(i) ) {
                        i++;
                        found = true;
                    } else {
                        found = false;
                    }
                }
            }

            if ( i == this.code.length() ) {
                found = true;
            }
        }
        this.unlock(found);
    }

    /**
     * Checks if the code is good or not after it has been typed.
     */
    public void typeCheckFullCode () {
        boolean found = false;

        System.out.println("Tapez le code, puis appuyez sur la touche \"Entrée\".");
        String typed = typeFullCode();
        if ( typed.equals(this.code) ) {
            found = true;
        }
        this.unlock(found);
    }

    /**
     * Checks if the code has been found.
     * If it is the case, prints "door unlocked" and else "door not unlocked".
     * @param found a boolean that tells if the code is good
     */
    private void unlock ( boolean found ) {
        if ( found == true ) {
            System.out.println("door unlocked");
        } else {
            System.out.println("door not unlocked");
        }
    }

    /**
     * Checks if the code given as a parameter is the good one or not.
     * I just made this method for the test class.
     * @param code the String chain containing the code
     * @return true if the code is good, else false
     */
    public boolean isItCode ( String code ) {
        boolean yes = false;
        if ( code.equals(this.code) ) {
            yes = true;
        }
        return yes;
    }



}
