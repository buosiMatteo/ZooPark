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

    public void aggiungiSezione(Section section) {
        this.sezioni.add(section);
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

    public Section selezionaSezione(Section section) throws SectionNotAvailableExeption {
        for (Section s : this.getSezioni()) {
            if (s.equals(section)) {
                return s;
            } else {
                throw new SectionNotAvailableExeption();
            }

        }
        throw new SectionNotAvailableExeption();
    }

    public boolean cercaAnimale(Animals animals) throws AnimalsNotInTheZooExeption {
        for (Section s : sezioni) {
            for (Animals a : s.getAnimalsSet()) {
                if (a.equals(animals)) {
                    return true;
                }
            }
        }
        throw new AnimalsNotInTheZooExeption();
    }

    @Override
    public String toString() {
        return String.format("Lo Zoo si chiama %s ha al massimo %s animali e ha queste sezioni %s", getNome(), getAnimaliMassimi(),sezioni);
    }
}
