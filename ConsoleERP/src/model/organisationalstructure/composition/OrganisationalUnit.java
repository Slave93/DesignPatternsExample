package model.organisationalstructure.composition;


//component
public abstract class OrganisationalUnit {	
	public abstract String getStructureString(int level);
	public void addUnit(OrganisationalUnit organisationalUnit){}
	public OrganisationalUnit getUnit(int i){
		return null;
	}
}
