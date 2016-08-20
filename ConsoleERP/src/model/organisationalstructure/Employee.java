package model.organisationalstructure;

import model.organisationalstructure.composition.OrganisationalUnit;

public class Employee extends OrganisationalUnit {
	private String name;
	private String degree;
	private int yearsEmplyed;
		
	public Employee() {

	}
	public Employee(String name, String degree, int yearsEmplyed) {		
		this.name = name;
		this.degree = degree;
		this.yearsEmplyed = yearsEmplyed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public int getYearsEmplyed() {
		return yearsEmplyed;
	}
	public void setYearsEmplyed(int yearsEmplyed) {
		this.yearsEmplyed = yearsEmplyed;
	}
	@Override
	public String getStructureString(int level) {
		return "Employee (name= "+name+")";
	}
	
	
	
	
}
