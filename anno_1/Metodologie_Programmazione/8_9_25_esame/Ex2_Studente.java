import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Ex2_Studente
implements Iterable<Ex2_Esame>
{
    String nome;
    String cognome;
    int anno_di_escrizione;
    Collection<Ex2_Esame> esami = new ArrayList();

    public Ex2_Studente(String nome, String cognome, int anno_di_escrizione) {
        this.nome = nome;
        this.cognome = cognome;
        this.anno_di_escrizione = anno_di_escrizione;
    }

    @Override
    public Iterator<Ex2_Esame> iterator() {
        return esami.iterator();
    }

    @Override
    public int hashCode() {
        int hash = anno_di_escrizione * nome.hashCode() * cognome.hashCode();
        for (Ex2_Esame esame : esami) {
            hash *= esame.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Ex2_Studente)) return false;
        return this.hashCode() == obj.hashCode();
    }
}
