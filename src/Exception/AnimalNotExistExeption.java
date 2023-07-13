package Exception;

public class AnimalNotExistExeption extends Exception {
    public AnimalNotExistExeption() {
        super("L'animale cercato non è presente in nessun zoo");
    }
}
