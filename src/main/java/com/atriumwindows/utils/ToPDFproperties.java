package com.atriumwindows.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nni on 1/7/2016.
 */
public class ToPDFproperties {

    //Singleton, encapsulate properties by ToPDFListener
    private Map<String, String> properties = new HashMap<>();

    private ToPDFproperties(){}

    private static final ToPDFproperties instance = new ToPDFproperties();

    public static ToPDFproperties getInstance() {
        return instance;
    }

    public void addProperty(String propertyName, String propertyValue) {
        properties.put(propertyName, propertyValue);
    }

    public String getProperty(String propertyName) {
        return properties.get(propertyName);
    }
}
