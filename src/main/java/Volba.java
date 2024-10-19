
/**
 *
 * @author karel@simerda.cz
 */
public enum Volba {
    KAMEN("kámen"), NUZKY("nůžky"), PAPIR("papir");

    private final String text;

    private Volba(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Volba{" + text + '}';
    }
    
    
}
