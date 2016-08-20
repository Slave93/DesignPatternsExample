package main;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

import javax.sound.midi.ControllerEventListener;

import database.ControllorSingleton;
import util.tax.TaxAdministration;
import main.util.ConsoleHelper;
import model.AirConditioner;
import model.AirConditionerService;
import model.BusinessPartner;
import model.Product;
import model.ProductToServiceAdapter;
import model.Service;
import model.Television;
import model.document.BusinessDocument;
import model.document.Invoice;
import model.document.Offer;
import model.offerbuilder.NewYearOfferBuilder;
import model.offerbuilder.SpecialOfferBuilder;
import model.organisationalstructure.Company;
import model.organisationalstructure.Department;
import model.organisationalstructure.Employee;

public class ClientApp {

	Company company;
	SpecialOfferBuilder specialOfferBuilder;	
	
	public ClientApp(SpecialOfferBuilder sop){
		this.specialOfferBuilder = sop;
	}
	
	public ClientApp(Company company){
		this.company = company;
	}
	
	public ClientApp(){
		
	}
	
	public void prepareOffer(){
		specialOfferBuilder.buildProductList();
		specialOfferBuilder.buildServiceList();
		specialOfferBuilder.buildSpecialOffer();		
	}
	
	public void getSpecialOffer() {
		specialOfferBuilder.getSpecialOffer();
	}
	
	public void printOutOrgStructure(){
		System.out.println("Company organisational structure "+ company.getName() + "\n"+company.getStructureString(0));
	}

	public List<Product> getAllProducts(){
		return ControllorSingleton.getInstance().getProductCatalog();
	}
	
	public List<Service> getAllServices(){
		return ControllorSingleton.getInstance().getServiceCatalog();
	}
	
	public List<BusinessDocument> getAllDocuments(){
		return ControllorSingleton.getInstance().getDocumentArchive();
	}
	
	public static void main(String[] args) throws Exception {
		
		Company comp = ConsoleHelper.createCompanyConsole();
		ClientApp client1 = new ClientApp(comp);
		client1.printOutOrgStructure();
		
		TaxAdministration taxAdministration = new TaxAdministration();
		taxAdministration.setCurrentPDV(21.00);
		ConsoleHelper.pdvSetUpConsole(taxAdministration);		
		
		
		SpecialOfferBuilder specialOfferBuilder = ConsoleHelper.createSpecialOfferBuilderConsole();
		if(specialOfferBuilder!=null){
			ClientApp client2 = new ClientApp(specialOfferBuilder);
			client2.prepareOffer();
			Offer offer = specialOfferBuilder.getSpecialOffer();
			offer.setTaxAdministration(taxAdministration);
			ConsoleHelper.doucmentProcessing(offer);
		}
		
		ClientApp client3 = new ClientApp();		
		ConsoleHelper.multipleInvoiceCreationAndProcessing(client3.getAllProducts(), client3.getAllServices(), taxAdministration);
		

		if(ConsoleHelper.pdvSetUpConsole(taxAdministration)){
			if(ConsoleHelper.recratePDFs()){
				List<BusinessDocument> savedDocuments = client3.getAllDocuments();
				for(BusinessDocument businessDocument : savedDocuments){
					businessDocument.generatePDF();
				}
			}
		};
	}
}
