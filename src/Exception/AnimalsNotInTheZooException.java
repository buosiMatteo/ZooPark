package Exception;

public class AnimalsNotInTheZooException extends Exception {
    public AnimalsNotInTheZooException(){
        super("Animal not located in this zoo");
    }
}
