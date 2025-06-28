package borsa;

import java.util.ArrayList;
import java.util.List;

public class AnalizzatoreStatistiche extends Analizzatore{

	private List<Transazione> transazioni=new ArrayList<Transazione>();
	
	@Override
	public void analizza(Transazione t)
	{
		transazioni.add(t);
	}
	
	@Override
	public String toString()
	{
		double importo=0.0;
		for (Transazione t:transazioni) importo+=t.getImporto();
		return "IMPORTO MEDIO DELLE TRANSAZIONI = "+importo/transazioni.size();
	}
}
