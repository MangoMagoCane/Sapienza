import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LabirintoMatrice {
    Cella[][] labirinto;
    int n, m;

    public LabirintoMatrice(int n, int m) {
        labirinto = new Cella[n][m];
        this.n = n;
        this.m = m;
        initLabirinto();
    }

    private void initLabirinto() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                labirinto[i][j] = new Muro(i, j);

        Random randomizer = new Random();
        int numeroEstrazioni = (int)(((n-2) * (m-2)) * 0.8);
        do {
            int ri = randomizer.nextInt(n-2);
            int rj = randomizer.nextInt(m-2);
            labirinto[ri+1][rj+1] = new Stanza(ri+1, rj+1, false);
            numeroEstrazioni--;
        } while (numeroEstrazioni > 0);

        int i = n/2;
        int j = m/2;
        labirinto[i][j] = new Stanza(i, j, true);
    }

    public boolean percorri(int x, int y) {
        List<Stanza> filoDiArianna = new ArrayList<>();
        if (percorriRicorsivo(y, x, filoDiArianna, new HashSet<>())) {
            filoDiArianna.forEach(c -> System.out.println(c.location()));
            return true;
        }
        return false;
    }

    private boolean percorriRicorsivo(int i, int j, List<Stanza> filo, Set<Cella> visitate) {
        Cella cella = labirinto[i][j];
        if (i == 0 || i == n-1 || j == 0 || j == m-1)
            return false;
        if (visitate.contains(cella))
            return false;
        visitate.add(cella);
        if (cella instanceof Muro)
            return false;
        if (((Stanza)cella).getContainsMinotauro())
            return true;
        filo.add((Stanza)cella);
        return  percorriRicorsivo(i-1, j, filo, visitate) ||
                percorriRicorsivo(i+1, j, filo, visitate) ||
                percorriRicorsivo(i, j-1, filo, visitate) ||
                percorriRicorsivo(i, j+1, filo, visitate);
    }

    public void stampa() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(labirinto[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) {
        boolean done;
        do {
            LabirintoMatrice lab = new LabirintoMatrice(10, 10);
            lab.stampa();
            done = lab.percorri(1, 1);
            System.out.println(done);
        } while (!done);
    }
}
