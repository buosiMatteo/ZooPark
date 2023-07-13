import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.valueOf;

public class Section {
    private TypeOfSection tipoDiSezione;
    private LocalDateTime orarioDiApertura;
    private LocalDateTime orarioDiChiusura;
    private final Set<Animals> animalsSet;

    public Section(TypeOfSection tipoDiSezione, LocalDateTime orarioDiApertura, LocalDateTime orarioDiChiusura) {
        this.tipoDiSezione = tipoDiSezione;
        this.orarioDiApertura = orarioDiApertura;
        this.orarioDiChiusura = orarioDiChiusura;
        this.animalsSet = new HashSet<>();
    }

    public void aggiungiAnimale(Animals animale) {
        animalsSet.add(animale);
    }

    public Set<Animals> getAnimalsSet() {
        return animalsSet;
    }

    public void printAnimalsSet() {
        for (Animals a : animalsSet) {
            System.out.println(a);
        }
    }

    public TypeOfSection getTipoDiSezione() {
        return tipoDiSezione;
    }

    public LocalDateTime getOrarioDiApertura() {
        return orarioDiApertura;
    }

    public LocalDateTime getOrarioDiChiusura() {
        return orarioDiChiusura;
    }

    @Override
    public String toString() {
        return "Section{" +
                "tipoDiSezione=" + tipoDiSezione +
                '}';
    }
}
