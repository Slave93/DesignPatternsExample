package util.tax;

public abstract class TaxListener {
	
	protected double currentPDVRate = 0.00;
	protected TaxAdministration taxAdministration;
	
	public TaxListener(){
		
	}
	
	public void setTaxAdministration(TaxAdministration taxAdministration){
		this.taxAdministration = taxAdministration;
		taxAdministration.addTaxListener(this);
		pdvChanged();
	}
	
	public void pdvChanged(){
		if(taxAdministration!=null)
			this.currentPDVRate = taxAdministration.getCurrentPDV();
	}

}
