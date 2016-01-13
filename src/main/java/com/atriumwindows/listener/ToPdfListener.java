package com.atriumwindows.listener;

import com.atriumwindows.utils.ToPDFproperties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * Created by nni on 1/6/2016.
 */
@WebListener()
public class ToPDFListener implements ServletContextListener {

    public ToPDFListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //load Servlet Context Path
        ToPDFproperties.getInstance().addProperty("servletcontextpath", servletContextEvent.getServletContext().getContextPath());

        InputStream in = getClass().getClassLoader().getResourceAsStream("topdf.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);

            for(Map.Entry prop: properties.entrySet()) {
                String propertyName = (String) prop.getKey();
                String propertyValue = (String) prop.getValue();
                ToPDFproperties.getInstance().addProperty(propertyName,propertyValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
