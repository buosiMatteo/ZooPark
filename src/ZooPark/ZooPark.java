package ZooPark;

import Exception.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ZooPark {
    private String nome;
    private final LocalDateTime orarioDiApertura;
    private final LocalDateTime orarioDiChiusura;
    private final int animaliMassimi;
    private final Set<Section> sezioni;

    public ZooPark(String nome, LocalDateTime orarioDiApertura, LocalDateTime orarioDiChiusura, int animaliMassimi) {
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

    public LocalDateTime getOrarioDiApertura() {
        return orarioDiApertura;
    }

    public int getAnimaliMassimi() {
        return animaliMassimi;
    }

    public LocalDateTime getOrarioDiChiusura() {
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
        return String.format("Lo Zoo si chiama %s ha al massimo %s animali e ha queste sezioni %s", getNome(), getAnimaliMassimi(),sezioni);
    }
}
