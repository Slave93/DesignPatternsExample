package model.organisationalstructure;
import java.util.ArrayList;
import java.util.List;

import model.document.BusinessDocument;
import model.organisationalstructure.composition.OrganisationalUnit;
public class Department extends OrganisationalUnit {
	
	private String name;
	private List<BusinessDocument> businessDocuments;
	private List<OrganisationalUnit> organisationalUnits = new ArrayList<OrganisationalUnit>();
	
	public Department() {
		
	}
	public Department(String name, List<BusinessDocument> businessDocuments) {		
		this.name = name;
		this.businessDocuments = businessDocuments;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BusinessDocument> getBusinessDocuments() {
		return businessDocuments;
	}
	public void setBusinessDocuments(List<BusinessDocument> businessDocuments) {
		this.businessDocuments = businessDocuments;
	}
	@Override
	public String getStructureString(int level) {
		String children = "";
		String prefiks = "";
		for (int i = 0; i <= level; i++) {
			prefiks+="\t";
		}		
		for (int i = 0; i < organisationalUnits.size(); i++) {
			children+=prefiks+organisationalUnits.get(i).getStructureString(level+1);
			if(i!=organisationalUnits.size()-1){
				children+=",\n ";
			}else{
				children+="]";
			}
		}
		return "Department (name=" + name +"[\n"+children+")";
	}
	
	@Override
	public void addUnit(OrganisationalUnit organisationalUnit) {
		this.organisationalUnits.add(organisationalUnit);
	}
	
	@Override
	public OrganisationalUnit getUnit(int i) {
		return this.organisationalUnits.get(i);
	}
	@Override
	public String toString() {
		return "Department [name=" + name+" ";
	}
	
	public void exportDocumentsToPDF(){
		for(BusinessDocument businessDocument : businessDocuments){
			try{
				businessDocument.generatePDF();
			}catch(Exception e){
				System.err.println("Unable to generate pdf for document: "+ businessDocument.getDocumentName()+" number "+businessDocument.getDocumentNumber());
				System.out.println("Reason: "+e.getMessage());
			}
		}
	}
	
	
	
	
	
}
