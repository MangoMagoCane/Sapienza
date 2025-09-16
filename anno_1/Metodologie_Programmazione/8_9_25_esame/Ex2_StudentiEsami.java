import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex2_StudentiEsami
implements Iterable<Ex2_Studente>
{
    private static Ex2_StudentiEsami instance = null;
    Collection<Ex2_Studente> studenti;

    private Ex2_StudentiEsami() {}

    public static Ex2_StudentiEsami getInstance() {
        if (instance == null) {
            instance = new Ex2_StudentiEsami();
        }
        return instance;
    }

    public Map<Integer, Set<Ex2_Studente>> getMappaAnnoDiIscrizioneStudenti(int annoInizio, int annoFine) {
        return studenti.stream()
                .filter(s -> s.anno_di_escrizione >= annoInizio && s.anno_di_escrizione <= annoFine)
                .collect(
                    Collectors.groupingBy(
                        s -> s.anno_di_escrizione,
                        Collectors.toSet()));
    }

    public int getMediaVotiAnno(int anno) {
        return studenti.stream()
                .filter(s -> s.anno_di_escrizione == anno)
                .map(s -> s.anno_di_escrizione)
                .reduce(0, (a, b) -> a + b) / studenti.size();
    }

    @Override
    public Iterator<Ex2_Studente> iterator() {
        return studenti.iterator();
    }
}
