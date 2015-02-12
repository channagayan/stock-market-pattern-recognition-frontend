/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arcane.model;

/**
 * @Created : 2/7/2015.
 * Head and Shoulder Pattern Model
 */
public class HeadnShoulder extends Pattern {

    private String firstMax;
    private String secondMax;
    private String thirdMax;
    private String firstMin;
    private String secondMin;
    private String breakPoint;
    private double firstMaxPrice;
    private double secondMaxPrice;
    private double thirdMaxPrice;
    private double firstMinPrice;
    private double secondMinPrice;
    private double breakPointPrice;

    public String getFirstMax() {
        return firstMax;
    }

    public void setFirstMax(String firstMax) {
        this.firstMax = firstMax;
    }

    public String getSecondMax() {
        return secondMax;
    }

    public void setSecondMax(String secondMax) {
        this.secondMax = secondMax;
    }

    public String getThirdMax() {
        return thirdMax;
    }

    public void setThirdMax(String thirdMax) {
        this.thirdMax = thirdMax;
    }

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

    public double getSecondMaxPrice() {
        return secondMaxPrice;
    }

    public void setSecondMaxPrice(double secondMaxPrice) {
        this.secondMaxPrice = secondMaxPrice;
    }

    public double getThirdMaxPrice() {
        return thirdMaxPrice;
    }

    public void setThirdMaxPrice(double thirdMaxPrice) {
        this.thirdMaxPrice = thirdMaxPrice;
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

    public double getBreakPointPrice() {
        return breakPointPrice;
    }

    public void setBreakPointPrice(double breakPointPrice) {
        this.breakPointPrice = breakPointPrice;
    }
}
