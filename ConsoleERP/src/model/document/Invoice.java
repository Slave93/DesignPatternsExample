/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.document;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.BusinessPartner;
import model.Product;

/**
 *
 * @author Slavko
 */
public class Invoice extends BusinessDocument {

	private static int numOfInvoices = 0;
	private Map<Product, Integer> productList = new HashMap<Product, Integer>();
	private BusinessPartner businessPartner;
	private double pdv = -1d;
	private double sum = -1d;

	public Invoice() {
		super();
		this.documentNumber = ++numOfInvoices;
	}

	public static int getNumOfInvoices() {
		return numOfInvoices;
	}

	public Map<Product, Integer> getProductList() {
		return productList;
	}

	public void setProductList(Map<Product, Integer> productList) {
		this.productList = productList;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	public double getPdv() {
		return pdv;
	}

	public double getSum() {
		return sum;
	}

	@Override
	public String getDocumentName() {
		return "Invoice";
	}

	@Override
	public void saveValidation() throws Exception {
		String error = "";

		if (businessPartner == null) {
			error += "Bussiness partner must be set before saving invoice";
		}

		if (!error.equals("")) {
			throw new Exception(error);
		}

	}

	@Override
	public void completeValidation() throws Exception {
		if (productList == null || productList.isEmpty()) {
			throw new Exception(
					"Invoice must have lines in order do be completed!");
		}
	}

	@Override
	public void completeOperation() {
		double netSum = 0;
		for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
			netSum += entry.getValue() * entry.getKey().getPrize();
		}
		pdv = netSum * currentPDVRate / 100.0;
		sum = netSum + pdv;
	}

	@Override
	public String getHeader() {
		String header = "INVOICE(" + getStatus() + ")\n\n";
		header += "Business Parnter\n";
		header += businessPartner.getName() + "\n";
		header += businessPartner.getAddress() + "\n";
		return header;
	}

	@Override
	public List<String> getLines() {
		List<String> lines = new ArrayList<>();
		for (Map.Entry<Product, Integer> entry : productList.entrySet()) {
			String line = "";
			Product product = entry.getKey();
			line += product.getName() + ", ";
			line += product.getPrize() + " per " + product.getUnit() + ", ";
			line += entry.getValue() + " " + product.getUnit() + "s ";
			if (sum > -1) {
				line += ", total: " + sum;
				line += ", pdv: " + pdv;
			}
			lines.add(line);
		}
		return lines;
	}

	@Override
	public String getFooter() {
		String footer = "Signature:"; 
		if(getStatus().equalsIgnoreCase("COMPLETED"))
			footer+="\nPDV Rate: " + currentPDVRate;
		return footer;
	}

}
