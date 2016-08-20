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
public class AirConditioner implements Product {

    private String model;
    private double prize;
    private String description;
    private String size;

    public AirConditioner(String model, double prize, String description, String size) {
        this.model = model;
        this.prize = prize;
        this.description = description;
        this.size = size;
    }
    
     @Override
    public double getPrize() {
        return prize;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getUnit() {
        return "unit";
    }

    @Override
    public String getName() {
        return "Air Conditioner: "+model;
    }
  
    public String getModel() {
        return model;
    }   

    public String getSize() {
        return size;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSize(String size) {
        this.size = size;
    }   
    
   
    
}
