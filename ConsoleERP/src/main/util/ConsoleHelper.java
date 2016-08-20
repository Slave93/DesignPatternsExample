package main.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.itextpdf.text.log.SysoCounter;

import util.tax.TaxAdministration;
import model.BusinessPartner;
import model.Product;
import model.ProductToServiceAdapter;
import model.Service;
import model.document.BusinessDocument;
import model.offerbuilder.ChristmassOfferBuilder;
import model.offerbuilder.NewYearOfferBuilder;
import model.offerbuilder.SpecialOfferBuilder;
import model.organisationalstructure.Company;
import model.organisationalstructure.Department;
import model.organisationalstructure.Employee;
import model.document.Invoice;

public class ConsoleHelper {
	private static Scanner s = new Scanner(System.in);

	public static Company createCompanyConsole() {

		System.out.println("Enter your company name:");
		String companyName = s.nextLine();
		Company comp = new Company();
		comp.setName(companyName);
		String sledeæiSektor = "";
		while (true) {
			System.out.println("Enter the name "
					+ "of the " +sledeæiSektor+ companyName
					+ " department(for ending department input press \"END\")");
			sledeæiSektor = "next ";
			String departmentName = s.nextLine();
			if (departmentName.equalsIgnoreCase("END")) {
				break;
			}
			Department dep = new Department();
			dep.setName(departmentName);
			comp.addUnit(dep);
			System.out.println("Enter the name of the department "
					+ departmentName
					+ " employees(for ending employees input press \"END\")");
			while (true) {
				String employeeName = s.nextLine();
				if (employeeName.equalsIgnoreCase("END")) {
					break;
				}
				Employee emp = new Employee();
				emp.setName(employeeName);
				dep.addUnit(emp);
			}
		}
		System.out
				.println("Enter the  "
						+ companyName
						+ " employee names that do not work in departments(for ending employees input press \"END\")");
		while (true) {
			String employeeName = s.nextLine();
			if (employeeName.equalsIgnoreCase("END")) {
				break;
			}
			Employee emp = new Employee();
			emp.setName(employeeName);
			comp.addUnit(emp);
		}
		return comp;

	}

	public static SpecialOfferBuilder createSpecialOfferBuilderConsole() {

		SpecialOfferBuilder sob = null;
		System.out
				.println("There are two special offers: new years and christmass. Press N for new years or C for christmass offer ");
		String so = s.nextLine();
		if (so.equalsIgnoreCase("C"))
			sob = new ChristmassOfferBuilder();
		if (so.equalsIgnoreCase("N"))
			sob = new NewYearOfferBuilder();

		return sob;
	}

	public static void doucmentProcessing(BusinessDocument bd) {

		System.out
				.println("Pres S if you want to save "
						+ "document"
						+ " , C for completing, P for generating pdf-a or END for ending document processing");
		while (true) {
			String choice = s.nextLine();
			if (choice.equalsIgnoreCase("END"))
				break;
			if (choice.equalsIgnoreCase("S")) {
				try {
					bd.save();
					System.out.println("Dokument je saèuvan");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			if (choice.equalsIgnoreCase("C")) {
				try {
					bd.complete();
					System.out.println("Dokument je kompletiran");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			if (choice.equalsIgnoreCase("P")) {
				try {
					bd.generatePDF();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}

	}

	public static boolean pdvSetUpConsole(TaxAdministration taxAdministration) {
		System.out
				.println("PDV percentage is currently "
						+ taxAdministration.getCurrentPDV()
						+ "%.If you want to change it enter wanted percentage, else enter NO");
		while (true) {
			String stopa = s.nextLine();
			if (stopa.equalsIgnoreCase("NO")) {
				return false;
			}
			try {
				Double stopaD = Double.parseDouble(stopa);
				taxAdministration.setCurrentPDV(stopaD);
				System.out.println("Pdv percentage is changed: "
						+ taxAdministration.getCurrentPDV() + "%");
				return true;
			} catch (Exception e) {
				System.out.println("Wrong input! Try again.");
			}
		}
	}

	public static boolean recratePDFs() {
		System.out
				.println("PDV percentage is changed.If you wish to recreate pdf documents now press YES.");
		String izbor = s.nextLine();
		if (izbor.equalsIgnoreCase("YES")) {
			return true;
		}
		return false;

	}

	public static Invoice createInvoicesConsole(List<Product> productList,
			List<Service> serviceList) {
		Invoice invoice = new Invoice();
		Map<Product, Integer> invoiceProducts = new HashMap<Product, Integer>();
		System.out.println("There are following products available: ");
		for (int i = 0; i < productList.size(); i++) {
			System.out.println((i + 1) + ". " + productList.get(i).getName());
		}
		System.out
				.println("Chose product number and wanted quantity(ex. 3,100). Press END for ending products input");
		while (true) {
			try {
				String unos = s.nextLine();
				if (unos.equalsIgnoreCase("END")) {
					break;
				}
				int zarez = unos.indexOf(",");
				if (zarez < 0) {
					throw new Exception("Wrong format");
				}
				String redniBroj = unos.substring(0, zarez);
				String kolièina = unos.substring(zarez + 1, unos.length());
				int redniBrojI = Integer.parseInt(redniBroj);
				Integer kolièinaD = Integer.parseInt(kolièina);
				invoiceProducts.put(productList.get(redniBrojI-1), kolièinaD);
			} catch (Exception e) {
				System.out.println("Wrong format, try again!");
			}
		}		
		System.out.println("There are following services available: ");
		for (int i = 0; i < serviceList.size(); i++) {
			System.out.println((i + 1) + ". " + serviceList.get(i).getType()+" - "+serviceList.get(i).getSpecification());
		}
		System.out
				.println("Chose service number and wanted quantity(ex. 3,100). Press END for ending products input");
		while (true) {
			try {
				String unos = s.nextLine();
				if (unos.equalsIgnoreCase("END")) {
					break;
				}
				int zarez = unos.indexOf(",");
				if (zarez < 0) {
					throw new Exception("Wrong format");
				}
				String redniBroj = unos.substring(0, zarez);
				String kolièina = unos.substring(zarez + 1, unos.length());
				int redniBrojI = Integer.parseInt(redniBroj);
				Integer kolièinaD = Integer.parseInt(kolièina);
				invoiceProducts
						.put(new ProductToServiceAdapter(serviceList
								.get(redniBrojI-1)), kolièinaD);
			} catch (Exception e) {
				System.out.println("Wrong format, try again!");
			}
		}
		invoice.setProductList(invoiceProducts);
		System.out.println("Enter business partner name");
		String businessPartner = s.nextLine();
		System.out.println("Enter business partner address");
		String businessPartnerAddresss = s.nextLine();
		invoice.setBusinessPartner(new BusinessPartner(businessPartner, businessPartnerAddresss));
		return invoice;
	}

	public static List<Invoice> multipleInvoiceCreationAndProcessing(List<Product> productList,
			List<Service> serviceList, TaxAdministration taxAdministration){
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		
		while(true){
			System.out.println("Do you wish to enter new invoice?(YES/NO)");
			String izbor = s.nextLine();
			if(izbor.equalsIgnoreCase("YES")){
				Invoice invoice = createInvoicesConsole(productList, serviceList);
				invoiceList.add(invoice);
				invoice.setTaxAdministration(taxAdministration);
				doucmentProcessing(invoice);				
			}
			if(izbor.equalsIgnoreCase("NO")){
				break;
			}
		}
		return invoiceList;
	}
}
