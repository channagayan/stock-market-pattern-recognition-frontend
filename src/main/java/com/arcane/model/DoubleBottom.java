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
 * Double Bottom Pattern Model
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
