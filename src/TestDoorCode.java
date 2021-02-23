import thecode.DoorCode;

/**
 * Tests the DoorCode class
 */
public class TestDoorCode {

    private static int nbTests;
    private static int nbTestsOK = 0;

    public static void main (String[] args) {

        /*
        testRapide();*/
        testConstructeur();


        results();
    }

    public static void results () {
        System.out.println("\n\n-------------------------------------");
        System.out.println("          RESULTATS DU TEST          ");
        System.out.println("-------------------------------------");

        double taux = (double) (nbTestsOK / nbTests) * 100;

        System.out.println(" Nombre de tests     " + nbTests);
        System.out.println(" Tests réussis       " + nbTestsOK);
        System.out.println(" Taux de réussite    " + taux + " %");

        System.out.println("-------------------------------------");

    }

    public static void testRapide () {
        System.out.println("\n\n|---[ Test rapide");

        System.out.println("\nCode 1 :");
        DoorCode porteImmeuble = new DoorCode( "02348A");
        porteImmeuble.typeCheckCode();

        System.out.println("\nCode 2 :");
        DoorCode porteEntree = new DoorCode( "B2762A1" );
        porteEntree.typeCheckFullCode();
    }

    public static void testConstructeur () {
        System.out.println("\n\n|---[ Test du construceur DoorCode()");
        DoorCode code;

        System.out.print("*** cas nominal : code = new DoorCode ( \"18249B\" ) : ");
        nbTests++;
        code = new DoorCode("18249B");
        if ( code.isItCode("18249B") == true ) {
            System.out.println("OK");
            nbTestsOK++;
        } else {
            System.out.println("ERREUR");
        }

        System.out.print("*** cas nominal : code = new DoorCode (  \"A7289\" ) : ");
        nbTests++;
        code = new DoorCode("A7289");
        if ( code.isItCode("A7289") == true ) {
            System.out.println("OK");
            nbTestsOK++;
        } else {
            System.out.println("ERREUR");
        }

        System.out.print("*** cas nominal : code = new DoorCode ( \"ABZOPQ\" ) : ");
        nbTests++;
        code = new DoorCode("ABZOPQ");
        if ( code.isItCode("ABZOPQ") == true ) {
            System.out.println("OK");
            nbTestsOK++;
        } else {
            System.out.println("ERREUR");
        }

        System.out.print("*** cas limite  : code = new DoorCode (     null ) : ");
        nbTests++;
        code = new DoorCode(null);
        if ( code.isItCode("") == true ) {
            System.out.println("OK");
            nbTestsOK++;
        } else {
            System.out.println("ERREUR");
        }

        System.out.print("*** cas limite  : code = new DoorCode (       \"\" ) : ");
        nbTests++;
        code = new DoorCode("");
        if ( code.isItCode("") == true ) {
            System.out.println("OK");
            nbTestsOK++;
        } else {
            System.out.println("ERREUR");
        }
    }

}
