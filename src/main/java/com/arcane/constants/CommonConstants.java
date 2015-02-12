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
package com.arcane.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Constants are defined here
 */
public class CommonConstants {
    public enum Pattern {
        //Pattern Name Enum
        tripplebottom("Triple Bottom"),
        trippletop("Triple Top"),
        doubletop("Double Top"),
        doublebottom("Double Bottom"),
        headnshoulder("Head and Shoulder"),
        headnshoulderbottom("Head and Shoulder Inverse");

        private String description;

        private Pattern(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public static Map<String, String> getPatternMap() {
            Map<String, String> map = new LinkedHashMap<String, String>();
            for (Pattern pattern : Pattern.values()) {
                map.put(pattern.toString(), pattern.getDescription());
            }
            return map;
        }
    }

    public enum Company {
        // Company name Enum
        a("Company A"),
        b("Company B");

        private String description;

        private Company(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public static Map<String, String> getCompanyMap() {
            Map<String, String> map = new LinkedHashMap<String, String>();
            for (Company company : Company.values()) {
                map.put(company.toString(), company.getDescription());
            }
            return map;
        }
    }
}
