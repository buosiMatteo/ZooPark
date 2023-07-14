package ZooPark;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.valueOf;

public class Section {
    private TypeOfSection tipoDiSezione;
    private LocalTime orarioDiApertura;
    private LocalTime orarioDiChiusura;
    private final Set<Animals> animalsSet;

    public Section(TypeOfSection tipoDiSezione, LocalTime orarioDiApertura, LocalTime orarioDiChiusura) {
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

    public LocalTime getOrarioDiApertura() {
        return orarioDiApertura;
    }

    public LocalTime getOrarioDiChiusura() {
        return orarioDiChiusura;
    }

    @Override
    public String toString() {
        return String.valueOf(tipoDiSezione);
    }

    public boolean equals(Section s) {
        if (this.tipoDiSezione == s.tipoDiSezione) {
            return true;
        } else {
            return false;
        }
    }
}

