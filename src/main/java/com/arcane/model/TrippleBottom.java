package com.arcane.model;

/**
 * Created by Chann on 2/3/2015.
 */
public class TrippleBottom extends Pattern {
    private String firstMin;
    private String secondMin;
    private String thirdMin;
    private String breakPoint;
    private double firstMinPrice;
    private double secondMinPrice;
    private double thirdMinPrice;
    private double breakPointPrice;

    public String getFirstMin() {
        return firstMin;
    }

    public void setFirstMin(String firstMin) {
        this.firstMin = firstMin;
    }

    public String getSecondMin() {
        return secondMin;
    }

    public void setSecondMin(String secondMin) {
        this.secondMin = secondMin;
    }

    public String getThirdMin() {
        return thirdMin;
    }

    public void setThirdMin(String thirdMin) {
        this.thirdMin = thirdMin;
    }

    public String getBreakPoint() {
        return breakPoint;
    }

    public void setBreakPoint(String breakPoint) {
        this.breakPoint = breakPoint;
    }

    public double getFirstMinPrice() {
        return firstMinPrice;
    }

    public void setFirstMinPrice(double firstMinPrice) {
        this.firstMinPrice = firstMinPrice;
    }

    public double getSecondMinPrice() {
        return secondMinPrice;
    }

    public void setSecondMinPrice(double secondMinPrice) {
        this.secondMinPrice = secondMinPrice;
    }

    public double getThirdMinPrice() {
        return thirdMinPrice;
    }

    public void setThirdMinPrice(double thirdMinPrice) {
        this.thirdMinPrice = thirdMinPrice;
    }

    public double getBreakPointPrice() {
        return breakPointPrice;
    }

    public void setBreakPointPrice(double breakPointPrice) {
        this.breakPointPrice = breakPointPrice;
    }
}
