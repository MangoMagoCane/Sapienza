import java.util.Arrays;

public class Ex2_Esame
{
    int giorno = -1;
    int mese = -1;
    int anno = -1;
    int voto = -1;
    Ex2_Docente docente;
    Ex2_Insegnamento insegnamento;

    public Ex2_Esame(String date, int voto, Ex2_Docente docente, Ex2_Insegnamento insegnamento) { // 8/9/2025
        int[] delimed_date = Arrays.stream(date.split("//")).map(Integer::parseInt);
        int length = delimed_date.length;

        switch (length) {
        case 3: anno = delimed_date[2];
        case 2: mese = delimed_date[1];
        case 1: giorno = delimed_date[0];
        }

        this.docente = docente;
        this.insegnamento = insegnamento;

        if (voto >= 18 && voto <= 31) {
            this.voto = voto;
        }
    }

    @Override
    public int hashCode() {
        return giorno * mese * anno * voto * docente.hashCode() * insegnamento.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Ex2_Esame)) return false;
        return this.hashCode() == obj.hashCode();
    }
}
