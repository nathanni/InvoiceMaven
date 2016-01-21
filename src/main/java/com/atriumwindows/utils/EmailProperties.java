package com.atriumwindows.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nni on 1/21/2016.
 */
public class EmailProperties {
    //Singleton, encapsulate properties by com.atriumwindows.listener.AppListener
    private Map<String, String> properties = new HashMap<>();

    private EmailProperties(){}

    private static final EmailProperties instance = new EmailProperties();

    public static EmailProperties getInstance() {
        return instance;
    }

    public void addProperty(String propertyName, String propertyValue) {
        properties.put(propertyName, propertyValue);
    }

    public String getProperty(String propertyName) {
        return properties.get(propertyName);
    }
}
