public class Main {
    String titoloDelProgramma="Esercizio";

    public static void main(String[] args){
        String sg1,sg2,sg3;
        int gG1,gG2,gG3,gG4;
        GiocoDaTavoloAPile g1 = new GiocoDaTavoloAPile("Simon",4,2);

        sg1=g1.toString(); // Simon 6
        gG1=g1.getNumeroGiocatori(); // 4
        gG2=((GiocoDaTavolo)g1).getNumeroGiocatori(); // 4
        gG3=GiocoDaTavolo.giocatori; // 4

        System.out.println(sg1);
        System.out.println(gG1);
        System.out.println(gG2);
        System.out.println(gG3);
        System.out.println(GiocoDaTavolo.giocatori);
        // DISEGANRE LO STATO DELLA MEMORIA IN QUESTO PUNTO
    }
}



