package com.arcane.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by DELL on 2/11/2015.
 */
public class CommonConstants {
    public enum Pattern {

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
