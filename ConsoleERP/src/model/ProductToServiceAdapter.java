/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Slavko
 */

//########################ADAPTER PATTERN#######################
//problem je što su se u preduzecu kreirale fakture samo za proizvode
//pa klase Invoice,PurchaseOrder,Offer ocekju klasu Product
//Kako su i za proizvod i za uslugu u suštini kod dokumenata 
//potrebne iste stvari nije bilo potrebno menjati klasu i sve podklase
//dokumenata vec prilagoditi interfejs klase Service interfejsu klase Product
public class ProductToServiceAdapter implements Product {
    
    private Service service;

    public ProductToServiceAdapter(Service service) {
        this.service = service;
    }   
    
    @Override
    public String getName() {
        return service.getType();
    }

    @Override
    public String getDescription() {
        return service.getSpecification();
    }

    @Override
    public double getPrize() {
        return service.getPrize();
    }

    @Override
    public String getUnit() {
        return service.getDurationUnit();
    }
    
}
