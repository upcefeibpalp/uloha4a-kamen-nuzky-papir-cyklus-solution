import java.util.Random;
import java.util.Scanner;

/**
 * Jednoduchá hra „Kámen, nůžky, papír“.
 *
 * <p>
 * Implementace je rozdělena podle pravidel a úloh hry do několika díčích kroků.
 * <p>
 * Metoda main obsahuje cyklus v jehož těle se volají metody z dílčími
 * odpovědnostmi (úkoly)
 * <ol>
 * <li>Nejdříve se se hráč vyzve k zadání jeho volby. Hráč se může rozhodnout
 * pro hru nebo může hru ukončit.</li>
 * <li>Poté zvolí volbu bot (počítač nahrazuje chování druhého hráče). </li>
 * <li>Když jsou zadány obě volby je provedeno vyhodnocení voleb.</li>
 * <li>V posledním kroku se zobrazí kdo jak volil a jaký je výsledek</li>
 * </ol>
 */
public class KamenNuzkyPapirHraApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            Volba uzivatelVyber = volbaUzivatel();
            if (uzivatelVyber == null) {
                System.out.println("Konec hry");
                System.exit(0);
            }
            Volba vyberBot = volbaBot();

            Vysledek vysledek = goHra(uzivatelVyber, vyberBot);            
            
            System.out.println("Hrac : " + uzivatelVyber.toString());
            System.out.println("AI   : " + vyberBot.toString());
            System.out.println("---------------------");
            System.out.println(vysledek);
        }
    }

    /**
     * Metoda vyhodnotí podle pravidel hru a výsledek předá v návratové hodnotě. 
     *
     * @return Vrací jednu ze tří možností výsledku z hlediska hráče.
     */
    private static Vysledek goHra(Volba uzivatel, Volba bot) {
        if (uzivatel == bot) {
            return Vysledek.REMIZA;
        } else if ((uzivatel == Volba.KAMEN && bot == Volba.NUZKY)
                || (uzivatel == Volba.NUZKY && bot == Volba.PAPIR)
                || (uzivatel == Volba.PAPIR && bot == Volba.KAMEN)) {
            return Vysledek.VYHRA;
        } else {
            return Vysledek.PROHRA;
        }
    }

    /**
     * Metoda obsluhuje vstup volby od hráče.
     *
     * Hráč může zvolit volbu nebo může zadat ukončení hry. Při chybě je hráč
     * vyzván k opakování zadání.
     *
     * @return Při správné volbě se vrací reference na příslušnou výčtovou
     * hodnotu. Pokud hráč se rozhodne o ukončení hry, tak se vrací
     * <code>null</code>.
     */
    private static Volba volbaUzivatel() {
        System.out.println("k - Kamen, n - Nuzky, p - Papir");
        Volba vyber;
        do {
            System.out.print("Zadej volbu: ");
            char znak = scanner.next().charAt(0);
            if (znak == 'e' || znak == 'E') {
                return null;
            }
            vyber = switch (znak) {
                case 'k', 'K' -> Volba.KAMEN;
                case 'n', 'N' -> Volba.NUZKY;
                case 'p', 'P' -> Volba.PAPIR;
                default -> null;
            };
            if (vyber == null) {
                System.out.println("Spatny vyber - opakuj");
            }
        } while (vyber == null);
        return vyber;
    }

    /**
     * Metoda emuluje chování druhého hráče (bot) tím, že náhodně zvolí hodnotu
     * výčtového typu.
     *
     * @return Reference na hodnotu výčtu.
     */
    private static Volba volbaBot() {
        Random random = new Random();
        Volba botVyber = Volba.values()[random.nextInt(Volba.values().length)];
        return botVyber;
    }
}
