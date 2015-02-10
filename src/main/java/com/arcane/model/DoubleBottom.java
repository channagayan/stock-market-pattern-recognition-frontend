package com.arcane.model;

/**
 * Created by Chann on 2/6/2015.
 */
public class DoubleBottom extends Pattern {
    private String firstMin;
    private String firstMax;
    private String secondMin;
    private double firstMinPrice;
    private double firstMaxPrice;
    private double secondMinPrice;
    private double breakPointPrice;
    private String breakPoint;

    public String getFirstMin() {
        return firstMin;
    }

    public void setFirstMin(String firstMin) {
        this.firstMin = firstMin;
    }

    public String getFirstMax() {
        return firstMax;
    }

    public void setFirstMax(String firstMax) {
        this.firstMax = firstMax;
    }

    public String getSecondMin() {
        return secondMin;
    }

    public void setSecondMin(String secondMin) {
        this.secondMin = secondMin;
    }

    public double getFirstMinPrice() {
        return firstMinPrice;
    }

    public void setFirstMinPrice(double firstMinPrice) {
        this.firstMinPrice = firstMinPrice;
    }

    public double getFirstMaxPrice() {
        return firstMaxPrice;
    }

    public void setFirstMaxPrice(double firstMaxPrice) {
        this.firstMaxPrice = firstMaxPrice;
    }

    public double getSecondMinPrice() {
        return secondMinPrice;
    }

    public void setSecondMinPrice(double secondMinPrice) {
        this.secondMinPrice = secondMinPrice;
    }

    public double getBreakPointPrice() {
        return breakPointPrice;
    }

    public void setBreakPointPrice(double breakPointPrice) {
        this.breakPointPrice = breakPointPrice;
    }

    public String getBreakPoint() {
        return breakPoint;
    }

    public void setBreakPoint(String breakPoint) {
        this.breakPoint = breakPoint;
    }
}
