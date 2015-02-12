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

import com.arcane.constants.CommonConstants;

import java.io.Serializable;

/**
 * @Created : 1/5/2015.
 * Pattern Model
 */
public class Pattern implements Serializable {
    private String name;
    private String patternEnum;
    private int id;
    private String stock;
    private String stockName;
    private String type;
    private String timeStamp;//for sorting the list in recent pattern table

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String company) {
        this.stock = company;
        this.stockName = CommonConstants.Company.getCompanyMap().get(company);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPatternEnum() {
        return patternEnum;
    }

    public void setPatternEnum(String patternEnum) {
        this.patternEnum = patternEnum;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setName(String name) {
        this.name = name;
        this.patternEnum = CommonConstants.Pattern.getPatternMap().get(name);
    }
}
