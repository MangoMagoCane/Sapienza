import java.util.ArrayList;
import java.util.Collection;

public class Ex2_Docente
{
    String nome;
    String cognome;
    Collection<Ex2_Insegnamento> insegnamenti = new ArrayList();

    public Ex2_Docente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public int hashCode() {
        int hash = nome.hashCode() * cognome.hashCode();
        for (Ex2_Insegnamento insegnamento : insegnamenti) {
            hash *= insegnamento.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Ex2_Docente)) return false;
        return this.hashCode() == obj.hashCode();
    }
}
