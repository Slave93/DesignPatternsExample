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
public interface Service {
    
    public String getType();
    public double getPrize(); 
    public double getDuration();
    public String getDurationUnit();
    public String getSpecification();
    
    
    
}
