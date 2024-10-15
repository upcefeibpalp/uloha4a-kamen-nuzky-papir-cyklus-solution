
import java.util.Random;
import java.util.Scanner;

/**
 *
 * Vytvořte jednoduchou hru „Kámen, nůžky, papír“.
 */
public class KamenNuzkyPapirHraApp {

    public static Volba[] PouzeHra = {Volba.KAMEN, Volba.NUZKY, Volba.PAPIR};

    static Volba uzivatelVyber;
    static Volba vyberBot;

    public static void main(String[] args) {

        while (true) {
            uzivatelVyber = volbaUzivatel();
            vyberBot = volbaBot();

            System.out.println("Hrac : " + uzivatelVyber.toString());
            System.out.println("AI   : " + vyberBot.toString());
            System.out.println("---------------------");

            String vysledek = goHra();            
            System.out.println(vysledek);
        }
    }

    private static String goHra() {
        String vysledek;
        if (uzivatelVyber == vyberBot) {
            vysledek = "remiza";
        } else if ((uzivatelVyber == Volba.KAMEN && vyberBot == Volba.NUZKY)
                || (uzivatelVyber == Volba.NUZKY && vyberBot == Volba.PAPIR)
                || (uzivatelVyber == Volba.PAPIR && vyberBot == Volba.KAMEN)) {
            vysledek ="Hrac vyhral";
        } else {
            vysledek = "Hrac prohral";
        }
        return vysledek;
    }

    private static Volba volbaUzivatel() {
        // Scanner pro ziskani uzivatelskeho vstupu z klavesnice
        Scanner scanner = new Scanner(System.in);
        System.out.println("k - Kamen, n - Nuzky, p - Papir");
        Volba uzivatelVyber = Volba.ERROR;
        do {
            // Nacteni uzivatelskeho vstupu
            System.out.print("Zadej volbu: ");
            uzivatelVyber = switch (scanner.next().charAt(0)) {
                case 'k', 'K' ->
                    Volba.KAMEN;
                case 'n', 'N' ->
                    Volba.NUZKY;
                case 'p', 'P' ->
                    Volba.PAPIR;
                case 'e', 'E' ->
                    Volba.EXIT;
                default ->
                    Volba.ERROR;
            };

            if (uzivatelVyber == Volba.EXIT) {
                System.out.println("Konec hry");
                System.exit(0);
            }

            if (uzivatelVyber == Volba.ERROR) {
                System.out.println("Spatny vyber - opakuj");

            }
        } while (uzivatelVyber == Volba.ERROR);
        return uzivatelVyber;
    }

    private static Volba volbaBot() {
        Random random = new Random();
        Volba botVyber = Volba.values()[random.nextInt(PouzeHra.length)];
        return botVyber;
    }
}
