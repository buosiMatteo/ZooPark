package ZooPark;

public enum TypeOfSection {
    STANDARD("Standard"),
    AQUATICI("Acquatici"),
    VOLATILI("Volatili");

    private final String nome;

    TypeOfSection(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

