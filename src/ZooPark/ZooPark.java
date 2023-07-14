package ZooPark;

import Exception.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class ZooPark {
    private String nome;
    private final LocalTime orarioDiApertura;
    private final LocalTime orarioDiChiusura;
    private final int animaliMassimi;
    private final Set<Section> sezioni;

    public ZooPark(String nome, LocalTime orarioDiApertura, LocalTime orarioDiChiusura, int animaliMassimi) {
        this.nome = nome;
        this.orarioDiApertura = orarioDiApertura;
        this.orarioDiChiusura = orarioDiChiusura;
        this.animaliMassimi = animaliMassimi;
        this.sezioni = new HashSet<>();
        ZooParkDB.zooParkList.add(this);
    }

    public Section aggiungiSezione(Section section) {
        this.sezioni.add(section);
        return section;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalTime getOrarioDiApertura() {
        return orarioDiApertura;
    }

    public int getAnimaliMassimi() {
        return animaliMassimi;
    }

    public LocalTime getOrarioDiChiusura() {
        return orarioDiChiusura;
    }

    public Set<Section> getSezioni() {
        return sezioni;
    }

    public Section selezionaSezione(Section section) throws SectionNotAvailableException {
        for (Section s : getSezioni()) {
            if (s.equals(section)) {
                return s;
            } else {
                throw new SectionNotAvailableException();
            }

        }
        throw new SectionNotAvailableException();
    }

    public boolean cercaAnimale(Animals animals) throws AnimalsNotInTheZooException {
        for (Section s : sezioni) {
            for (Animals a : s.getAnimalsSet()) {
                if (a.equals(animals)) {
                    return true;
                }
            }
        }
        throw new AnimalsNotInTheZooException();
    }

    @Override
    public String toString() {
        return String.format("The %s \n" +
                "with these section %s \n" +
                "and maximum capacity of %s\n", getNome(), sezioni, getAnimaliMassimi());
    }
}
