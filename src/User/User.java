package User;

import ZooPark.*;
import Exception.*;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class User implements UserOperation {
    @Override
    public List<ZooPark> cercaAnimale(Animals animal) {
        List<ZooPark> zooParkList = new ArrayList<>();
        for (ZooPark z : ZooParkDB.zooParkList) {
            try {
                if (z.cercaAnimale(animal)) {
                    zooParkList.add(z);
                }
            } catch (AnimalsNotInTheZooException e) {
                System.out.println(e.getMessage());
            }
        }
        return zooParkList;
    }

    @Override
    public boolean isThatZooOpen(ZooPark zooPark) {
        LocalTime now = LocalTime.now();
        if (!now.isBefore(zooPark.getOrarioDiApertura()) && !now.isAfter(zooPark.getOrarioDiChiusura())) {
            System.out.printf("%s is open now\n", zooPark);
            return true;
        } else {
            System.out.printf("%s is closed now\n",zooPark);
            return false;
        }
    }

    @Override
    public boolean findAnimalInZooPark(ZooPark zooPark, Animals animal) {
        try {
            System.out.println("This animal is present in that zoo");
            return zooPark.cercaAnimale(animal);
        } catch (AnimalsNotInTheZooException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    @Override
    public boolean visitAnimalInASection(ZooPark zooPark, Section section, Animals animal) {
        for (Section s : zooPark.getSezioni()) {
            for (Animals a : s.getAnimalsSet()) {
                if (a.equals(animal)) {
                    System.out.println("You can see this animal in that section of this zoo");
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public void printAnimalInAZooPark(ZooPark zooPark) {
        for (Section s : zooPark.getSezioni()) {
            for (Animals a : s.getAnimalsSet()) {
                System.out.println(a.toString());
            }
        }

    }

    @Override
    public void printAnimalInAZooParkForSection(ZooPark zooPark, Section section) {
        try {
            System.out.println("\n\nIn this section of this zoo you can see these animals:");
            for (Animals a : zooPark.selezionaSezione(section).getAnimalsSet()) {
                System.out.println(a.toString());
            }
        } catch (SectionNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
