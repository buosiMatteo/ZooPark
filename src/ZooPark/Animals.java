package ZooPark;

public class Animals {

    private final String nome;
    private int peso;
    private final TypeOfSection sezioneDiApparteneza;

    public Animals(String nome, int peso, TypeOfSection sezioneDiApparteneza) {
        this.nome = nome;
        this.peso = peso;
        this.sezioneDiApparteneza = sezioneDiApparteneza;
    }

    public String getNome() {
        return nome;
    }

    public TypeOfSection getSezioneDiApparteneza() {
        return sezioneDiApparteneza;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("\t - Nome razza: %s\n" + "\t - Peso animale: %s\n" + "\t - Tipo di animale: %s", getNome(), getPeso(), getSezioneDiApparteneza());
    }

    public boolean equals(Animals a) {
        if (this.nome == a.nome) {
            return true;
        } else {
            return false;
        }
    }
}
