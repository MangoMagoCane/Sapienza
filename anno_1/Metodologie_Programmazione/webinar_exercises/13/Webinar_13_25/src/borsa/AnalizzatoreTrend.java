package borsa;

public class AnalizzatoreTrend extends Analizzatore {

	private Transazione utlimaTransazione;
	private double trendImporto;
	
	@Override
	public void analizza(Transazione t)
	{
		if (utlimaTransazione==null) trendImporto=t.getImporto();
		else trendImporto=t.getImporto()-utlimaTransazione.getImporto();
		utlimaTransazione=t;
	}
	@Override
	public String toString()
	{
		return "TREND ="+trendImporto;
	}
	
}
