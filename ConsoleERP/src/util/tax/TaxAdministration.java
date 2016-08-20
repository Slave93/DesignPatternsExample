package util.tax;

import java.util.ArrayList;
import java.util.List;

//#####################OBSERVER PATTERN###################################
public class TaxAdministration {
	private double currentPDV = 0.00;	
	private List<TaxListener> taxListeners = new ArrayList<TaxListener>();
	
	public void setCurrentPDV(double PDVRate){
		this.currentPDV = PDVRate;
		for(TaxListener taxListener : taxListeners){
			taxListener.pdvChanged();
		}
	}
	
	public double getCurrentPDV(){
		return currentPDV;
	}
	
	public void addTaxListener(TaxListener taxListener){
		this.taxListeners.add(taxListener);		
	}
}
