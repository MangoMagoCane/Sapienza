public class GiocoDaTavoloAPile extends GiocoDaTavolo{
    int numeroGiocatori;
    int numeroPile;

    public GiocoDaTavoloAPile(String nomeDelGioco, int numeroGiocatori, int numeroPile) {
        super(nomeDelGioco, numeroGiocatori);
        this.numeroGiocatori=numeroGiocatori+2;
        this.numeroPile=numeroPile;
    }

    public String toString(){
        return nome+" "+numeroGiocatori;
    }
}

