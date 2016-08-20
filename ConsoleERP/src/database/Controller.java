package database;

import java.util.ArrayList;
import java.util.List;

import model.AirConditioner;
import model.AirConditionerService;
import model.Product;
import model.Service;
import model.Television;
import model.TelevisionService;
import model.document.BusinessDocument;

public class Controller {
	private List<Product> productCatalog;
	private List<Service> serviceCatalog;
	private List<BusinessDocument> documentArchive;
	
	public Controller(){
		productCatalog = new ArrayList<Product>();
		serviceCatalog = new ArrayList<Service>();
		documentArchive = new ArrayList<>();
		Product product1 = new AirConditioner("LW1815HR", 20000,
				"Very very very strong, and doenst produce noise! ", "1x1.3");
		Product product2 = new Television("LG101", 12000, 3000000, 75);
		Product product3 = new AirConditioner("LW2222HR", 20000,
				"Very light, great quality! ", "0-5x1");
		Product product4 = new Television("LG333", 100000, 2500000, 54);
		Service service1 = new AirConditionerService(120.00, 2,
				"Fixing your AirConditioner in no time!");
		Service service2 = new AirConditionerService(4500, 2.5,
				"Best AirCondition service in town!");
		Service service3 = new TelevisionService(3000, 1.5,
				"Servicing television with LED display");
		Service service4 = new TelevisionService(2000, 1.0,
				"Servicing television with LCD display");
		productCatalog.add(product1);
		productCatalog.add(product2);
		productCatalog.add(product3);
		productCatalog.add(product4);
		serviceCatalog.add(service1);
		serviceCatalog.add(service2);
		serviceCatalog.add(service3);
		serviceCatalog.add(service4);
	}
	
	
	public Product getProduct(int i) {
		return productCatalog.get(i);
	}

	public Product getProductByName(String name) {
		for (Product product : productCatalog) {			
			if (product.getName().equals(name))
				return product;
		}
		return null;
	}

	public Service getService(int i) {
		return serviceCatalog.get(i);
	}

	public Service getServiceBySpecification(String specification) {
		for (Service service : serviceCatalog) {
			if (service.getSpecification().equals(specification))
				return service;
		}
		return null;
	}

	public void saveProduct(Product product) {
		productCatalog.add(product);
	}

	public void saveService(Service service) {
		serviceCatalog.add(service);
	}

	public List<Product> getProductCatalog() {
		return productCatalog;
	}

	public void setProductCatalog(List<Product> productCatalog) {
		this.productCatalog = productCatalog;
	}

	public List<Service> getServiceCatalog() {
		return serviceCatalog;
	}

	public void setServiceCatalog(List<Service> serviceCatalog) {
		this.serviceCatalog = serviceCatalog;
	}

	public List<BusinessDocument> getDocumentArchive() {
		return documentArchive;
	}

	public void setDocumentArchive(List<BusinessDocument> documentArchive) {
		this.documentArchive = documentArchive;
	}
	
	public void addDocument(BusinessDocument businessDocument){
		documentArchive.add(businessDocument);
	}

	
	
}
