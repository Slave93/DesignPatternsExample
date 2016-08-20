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
public class AirConditionerService implements Service {

    private double prize;
    private double duration;
    private String specification;

    public AirConditionerService(double prize, double duration, String specification) {
        this.prize = prize;
        this.duration = duration;
        this.specification = specification;
    }

    @Override
    public double getPrize() {
        return prize;
    }

    @Override
    public double getDuration() {
        return duration;
    }

    @Override
    public String getDurationUnit() {
        return "hour";
    }

    @Override
    public String getSpecification() {
        return specification;
    }

    @Override
    public String getType() {
        return "Air Conditioner Service";
    }

}
