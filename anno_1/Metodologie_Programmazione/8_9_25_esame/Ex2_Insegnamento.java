import java.lang.NullPointerException;

public class Ex2_Insegnamento
implements Comparable<Ex2_Insegnamento>
{
    String nome;
    int CFU = -1;
    int anno = -1;
    int semestre = -1;

    public Ex2_Insegnamento(String nome, int CFU, int anno, int semestre) {
        this.nome = nome;
        if (CFU > 0) {
            this.CFU = CFU;
        }

        if (anno >= 1 && anno <= 3) {
            this.anno = anno;
        }

        if (semestre >= 1 && semestre <= 2) {
            this.semestre= semestre;
        }
    }

    @Override
    public int compareTo(Ex2_Insegnamento inseg) {
        if (inseg == null) {
            throw new NullPointerException("Cannot compare to \"inseg\" because it is null");
        }

        int anno_comp = ((Integer) anno).compareTo(inseg.anno);
        if (anno_comp == 0) {
            return ((Integer) semestre).compareTo(inseg.semestre);
        }

        return anno_comp;
    }

    @Override
    public int hashCode() {
        return nome.hashCode() * CFU * anno * semestre;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Ex2_Insegnamento)) return false;
        return this.hashCode() == obj.hashCode();
    }
}
