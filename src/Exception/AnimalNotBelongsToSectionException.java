package Exception;

public class AnimalNotBelongsToSectionException extends Exception {
    public AnimalNotBelongsToSectionException(){
        super("Animals dosen't belong to this section");
    }

}
