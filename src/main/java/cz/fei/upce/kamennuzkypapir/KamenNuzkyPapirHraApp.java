package cz.fei.upce.kamennuzkypapir;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * Vytvořte jednoduchou hru „Kámen, nůžky, papír“.
 */
public class KamenNuzkyPapirHraApp {

    public static void main(String[] args) {
        // Definovani konstant pro snadnejsi orientaci v kodu
        final byte KAMEN = 0;
        final byte NUZKY = 1;
        final byte PAPIR = 2;

        // Scanner pro ziskani uzivatelskeho vstupu z klavesnice
        Scanner scanner = new Scanner(System.in);

        // Generator nahodnych cisel. Pro generovani stale stejnych cisel nutno zadat seed
        Random random = new Random();

        System.out.println("0 - Kamen, 1 - Nuzky, 2 - Papir");

        // Nacteni uzivatelskeho vstupu
        System.out.print("Zadej volbu: ");
        byte uzivatelVyber = scanner.nextByte();

        // Overeni uzivatelskeho vstupu, pokud vstup nebyl validni...
        if (uzivatelVyber < KAMEN || uzivatelVyber > PAPIR) {
            System.out.println("Spatny vyber");
            System.exit(1); // Ukonci program...
        }

        // Generovani nahodneho cisla simulujiciho vyber pocitace v rozsahu <O, 3)
        byte botVyber = (byte) random.nextInt(KAMEN, PAPIR + 1);

        // Vypis vyberu bota
        System.out.println("AI volba: " + botVyber);

        System.out.println("---------------------");

        if (uzivatelVyber == botVyber) { // Pokud jsou obe hodnoty stejne, remiza
            System.out.println("Remiza");
        // Uzivatel vyhral pouze pokud...
        } else if ((uzivatelVyber == KAMEN && botVyber == NUZKY) // zvolil kamen A bot zvolil nuzky NEBO
                || (uzivatelVyber == NUZKY && botVyber == PAPIR) // zvolil nuzky A bot zvolil papir NEBO
                || (uzivatelVyber == PAPIR && botVyber == KAMEN)) { // zvolil papir A bot zvolil kamen
            System.out.println("Vyhra");
        } else { // V opacnem pripade uzivatel prohral
            System.out.println("Prohra");
        }

        System.out.println("Konec hry");
    }
}
