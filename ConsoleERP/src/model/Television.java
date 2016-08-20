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
public class Television implements Product {

    private String model;
    private double prize;
    private int colors;
    private int inches;

    public Television(String model, double prize, int colors, int inches) {
        this.model = model;
        this.prize = prize;
        this.colors = colors;
        this.inches = inches;
    }   
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getColors() {
        return colors;
    }

    public void setColors(int colors) {
        this.colors = colors;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }   
    
    @Override
    public String getName() {
        return "Television: "+model;
    }

    @Override
    public String getDescription() {
        return "Television with "+inches+" inch screen and "+colors+ "colors";
    }

    @Override
    public double getPrize() {
        return prize;
    }

    @Override
    public String getUnit() {
        return "unit";
    }
    
    
    
}
