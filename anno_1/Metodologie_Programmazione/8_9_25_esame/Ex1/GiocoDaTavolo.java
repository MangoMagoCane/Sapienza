public class GiocoDaTavolo {
    public static String produttore;
    public static String nome;
    public static int giocatori;

    int numeroGiocatori;

    public GiocoDaTavolo(String nomeDelGioco, int numeroGiocatori){
        nome=nomeDelGioco;
        this.numeroGiocatori=numeroGiocatori;
        giocatori+=numeroGiocatori;
    }

    public String toString() {
        return nome+" "+numeroGiocatori;
    }

    public int getNumeroGiocatori()	{
        return numeroGiocatori;
    }
}

