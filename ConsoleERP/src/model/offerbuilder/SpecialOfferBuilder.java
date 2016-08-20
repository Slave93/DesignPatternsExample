/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.offerbuilder;

import java.util.ArrayList;
import java.util.List;

import util.tax.TaxAdministration;
import model.BusinessPartner;
import model.document.Offer;
import model.Product;
import model.Service;

/**
 *
 * @author Slavko
 */
//#################Builder pattern######################
public abstract class SpecialOfferBuilder {
    
    protected List<Product> productList;
    protected List<Service> serviceList;
    protected Offer specialOffer;
    protected TaxAdministration taxAdminstration;

    public SpecialOfferBuilder() {
        productList = new ArrayList<>();
        serviceList = new ArrayList<>();        
        taxAdminstration = new TaxAdministration();        
    } 
   
    public abstract void buildProductList();
    public abstract void buildServiceList();
    public abstract void buildSpecialOffer();
    public Offer getSpecialOffer(){
        return specialOffer;
    }
    
}
