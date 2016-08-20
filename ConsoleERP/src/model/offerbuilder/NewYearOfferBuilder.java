/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.offerbuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import database.Controller;
import database.ControllorSingleton;
import model.AirConditioner;
import model.AirConditionerService;
import model.BusinessPartner;
import model.document.Offer;
import model.Product;
import model.ProductToServiceAdapter;
import model.Service;
import model.Television;
import model.TelevisionService;

/**
 *
 * @author Slavko
 */
public class NewYearOfferBuilder extends SpecialOfferBuilder {

	@Override
	public void buildProductList() {
		Controller c = ControllorSingleton.getInstance();

		Product product1 = c.getProductByName("Air Conditioner: LW1815HR");
		Product product2 = c.getProductByName("Television: LG101");
		if (product1 != null)
			productList.add(product1);
		if (product2 != null)
			productList.add(product2);
	}

	@Override
	public void buildServiceList() {
		Controller c = ControllorSingleton.getInstance();

		Service service1 = c
				.getServiceBySpecification("Fixing your AirConditioner in no time!");
		Service service2 = c
				.getServiceBySpecification("Servicing television with LCD display");
		if (service1 != null)
			serviceList.add(service1);
		if (service2 != null)
			serviceList.add(service2);
	}

	@Override
	public void buildSpecialOffer() {
		List<Product> servicesAndProducts = new ArrayList<Product>();
		for (Service service : serviceList) {
			servicesAndProducts.add(new ProductToServiceAdapter(service));
		}
		servicesAndProducts.addAll(productList);
		specialOffer = new Offer(servicesAndProducts);
		specialOffer.setOfferName("Special NEW YEAR OFFER");
		specialOffer.setTaxAdministration(taxAdminstration);
		taxAdminstration.setCurrentPDV(21.00);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 14);
		specialOffer.setDateTo(calendar.getTime());
	}

}
