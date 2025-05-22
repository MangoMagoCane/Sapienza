public class Stanza extends Cella {
    private boolean containsMinotauro;

    public Stanza(int i, int j, boolean containsMinotauro) {
        super(i, j);
        this.containsMinotauro = containsMinotauro;
    }

    public boolean getContainsMinotauro() {
        return containsMinotauro;
    }

    @Override
    public String toString() {
        return containsMinotauro ? "!" : " ";
    }

    public String location() {
        return "riga: " + i + ", colonna : " + j + " mino: " + containsMinotauro;
    }
}

