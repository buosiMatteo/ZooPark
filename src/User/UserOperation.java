package User;

import ZooPark.Animals;
import ZooPark.*;

import java.util.List;

public interface UserOperation {
    List<ZooPark> cercaAnimale(Animals animal);

    boolean isThatZooOpen(ZooPark zooPark);

    boolean findAnimalInZooPark(ZooPark zooPark, Animals animal);

    boolean visitAnimalInASection(ZooPark zooPark, Section section, Animals animal);

    void printAnimalInAZooPark(ZooPark zooPark);

    void printAnimalInAZooParkForSection(ZooPark zooPark, Section section);
}
