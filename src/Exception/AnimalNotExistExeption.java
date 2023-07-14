package Exception;

public class AnimalNotExistExeption extends Exception {
    public AnimalNotExistExeption() {
        super("The searching animal isn't located in any zoo");
    }
}
