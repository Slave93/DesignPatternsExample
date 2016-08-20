/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import model.Product;
import model.document.BusinessDocument;

/**
 *
 * @author Slavko
 */
public class Offer extends BusinessDocument {

	private static int numOfOffers = 0;

	private List<Product> productList = new ArrayList<Product>();	
	private double pdv = -1d;
	private Date dateTo = null;
	private String offerName;

	public Offer() {
		this.documentNumber = ++numOfOffers;
	}

	public Offer(List<Product> productList) {
		this.documentNumber = ++numOfOffers;
		this.productList = productList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public static int getNumOfOffers() {
		return numOfOffers;
	}
	
	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String description) {
		this.offerName = description;
	}
	
	@Override
	public String getDocumentName() {
		return "Offer";
	}	

	@Override
	public void saveValidation() throws Exception {
		String error = "";

		if(offerName==null){
			error+="Offer must have name in order to be saved!";
		}	

		if (!error.equals("")) {
			throw new Exception(error);
		}
	}

	@Override
	public void completeValidation() throws Exception {
		String error = "";
		if (dateTo == null) {
			error += "Offer must have expiration date in order to be completed!\n";
		}
		if (productList == null || productList.isEmpty()) {
			error += "Offer must have lines in order do be completed!";
		}
		if (!error.equals("")) {
			throw new Exception(error);
		}
	}

	@Override
	public String getHeader() {
		String header = "OFFER(" + getStatus() + ")\n"+getOfferName();
		return header;
	}

	@Override
	public List<String> getLines() {
		List<String> lines = new ArrayList<>();
		for (Product product : productList) {
			String line = "";
			line += product.getName() + ", ";
			line += product.getPrize() + " per " + product.getUnit();
			if (getStatus().equalsIgnoreCase("COMPLETED")) {
				line += ", pdv: " + (product.getPrize() * currentPDVRate) / 100.00;
			}
			lines.add(line);
		}
		return lines;
	}

	@Override
	public String getFooter() {
		if (getStatus().equalsIgnoreCase("COMPLETED")) {
			return "Valid to: " + dateTo + "\n"+"PDV: "+currentPDVRate;
		}
		return "";
	}

	

}
