package com.arcane.model;

/**
 * Created by Chann on 2/5/2015.
 */
public class Doubletop extends Pattern {

    private String firstMax;
    private String firstMin;
    private String secondMax;
    private String breakPoint;
    private double firstMaxPrice;
    private double firstMinPrice;
    private double secondMaxPrice;
    private double breakPointPrice;

    public String getFirstMax() {
        return firstMax;
    }

    public void setFirstMax(String firstMax) {
        this.firstMax = firstMax;
    }

    public String getFirstMin() {
        return firstMin;
    }

    public void setFirstMin(String firstMin) {
        this.firstMin = firstMin;
    }

    public String getSecondMax() {
        return secondMax;
    }

    public void setSecondMax(String secondMax) {
        this.secondMax = secondMax;
    }

    public String getBreakPoint() {
        return breakPoint;
    }

    public void setBreakPoint(String breakPoint) {
        this.breakPoint = breakPoint;
    }

    public double getFirstMaxPrice() {
        return firstMaxPrice;
    }

    public void setFirstMaxPrice(double firstMaxPrice) {
        this.firstMaxPrice = firstMaxPrice;
    }

    public double getFirstMinPrice() {
        return firstMinPrice;
    }

    public void setFirstMinPrice(double firstMinPrice) {
        this.firstMinPrice = firstMinPrice;
    }

    public double getSecondMaxPrice() {
        return secondMaxPrice;
    }

    public void setSecondMaxPrice(double secondMaxPrice) {
        this.secondMaxPrice = secondMaxPrice;
    }

    public double getBreakPointPrice() {
        return breakPointPrice;
    }

    public void setBreakPointPrice(double breakPointPrice) {
        this.breakPointPrice = breakPointPrice;
    }
}
