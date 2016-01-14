package com.atriumwindows.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nni on 1/7/2016.
 */
public class ToPDFProperties {

    //Singleton, encapsulate properties by com.atriumwindows.listener.ToPDFListener
    private Map<String, String> properties = new HashMap<>();

    private ToPDFProperties(){}

    private static final ToPDFProperties instance = new ToPDFProperties();

    public static ToPDFProperties getInstance() {
        return instance;
    }

    public void addProperty(String propertyName, String propertyValue) {
        properties.put(propertyName, propertyValue);
    }

    public String getProperty(String propertyName) {
        return properties.get(propertyName);
    }
}
