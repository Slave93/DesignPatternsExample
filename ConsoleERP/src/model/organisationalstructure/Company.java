package model.organisationalstructure;

import java.util.ArrayList;
import java.util.List;

import model.organisationalstructure.composition.OrganisationalUnit;

public class Company extends OrganisationalUnit {
	
	private List<OrganisationalUnit> organisationalUnits = new ArrayList<OrganisationalUnit>();
	private String name;
	private String location;
	private String activity;

	public Company() {

	}

	public Company(String name, String location, String activity) {
		super();
		this.name = name;
		this.location = location;
		this.activity = activity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
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
		return "Company (name=" + name +"[\n"+children+")";
	}	
	@Override
	public void addUnit(OrganisationalUnit organisationalUnit) {
		this.organisationalUnits.add(organisationalUnit);
	}
	@Override
	public OrganisationalUnit getUnit(int i) {
		return this.organisationalUnits.get(i);
	}

}
