/**
 *
 * @author kasi90244
 */
public enum Vysledek {
    REMIZA("remiza"), VYHRA("výhra"), PROHRA("prohra");
    
    private final String nazev;

    private Vysledek(String nazev) {
        this.nazev = nazev;
    }

    @Override
    public String toString() {
        return "Vysledek{" + nazev + '}';
    }
    
}
