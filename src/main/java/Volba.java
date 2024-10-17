
/**
 *
 * @author karel@simerda.cz
 */
public enum Volba {
    KAMEN("kámen"), NUZKY("nůžky"), PAPIR("papir"), EXIT("exit"), ERROR("error");

    private final String text;

    private Volba(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Volba{" + text + '}';
    }
    
    
}
