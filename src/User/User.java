package User;

import ZooPark.*;
import Exception.*;


import java.time.LocalDateTime;
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
        LocalDateTime now = LocalDateTime.now();
        return !now.isBefore(zooPark.getOrarioDiApertura()) && !now.isAfter(zooPark.getOrarioDiChiusura());
    }

    @Override
    public boolean findAnimalInZooPark(ZooPark zooPark, Animals animal) {
        try {
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
            for (Animals a : zooPark.selezionaSezione(section).getAnimalsSet()) {
                System.out.println(a.toString());
            }
        } catch (SectionNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
