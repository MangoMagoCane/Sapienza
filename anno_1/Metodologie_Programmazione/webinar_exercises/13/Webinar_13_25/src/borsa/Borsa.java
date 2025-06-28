package borsa;



public class Borsa {
 private Analizzatore analizzatoreStatistiche;
 private Analizzatore analizzatoreTrend;

 public void nuovaTansazione(Transazione t)
 {
	 analizzatoreStatistiche.analizza(t);
	 System.out.println(analizzatoreStatistiche.toString());
		
	 analizzatoreTrend.analizza(t);
	 System.out.println(analizzatoreTrend.toString());
		
 }
 /*PRIMO PROBELMA*/
 public Borsa()
 {
	 analizzatoreTrend=new AnalizzatoreTrend();
	 analizzatoreStatistiche=new AnalizzatoreStatistiche();
	 
 }
 
 public static void main(String[] args)
 {
	 Borsa borsa=new Borsa();
	 borsa.nuovaTansazione(new Transazione("Banca MIA",1.4));
	 borsa.nuovaTansazione(new Transazione("Banca TUA",8.4));
	 borsa.nuovaTansazione(new Transazione("Banca SUA",2.4));
	 	 
 }
}
