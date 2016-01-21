package com.atriumwindows.listener; /**
 * Created by Nathan on 1/13/2016.
 */

import com.atriumwindows.utils.EmailProperties;
import com.atriumwindows.utils.ToPDFProperties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

@WebListener()
public class AppListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public AppListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {

        //Get real path, set rootPath as a system property for LOG4J
        System.setProperty("rootPath", sce.getServletContext().getRealPath("/"));

        //load pdf.properties
        loadToPDFProperties(sce);

        //load email.properties
        loadEmailProperties(sce);


    }

    private void loadEmailProperties(ServletContextEvent sce) {
        InputStream in = getClass().getClassLoader().getResourceAsStream("email.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);

            for (Map.Entry prop : properties.entrySet()) {
                String propertyName = (String) prop.getKey();
                String propertyValue = (String) prop.getValue();
                EmailProperties.getInstance().addProperty(propertyName, propertyValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadToPDFProperties(ServletContextEvent sce) {
        //load Servlet Context Path
        ToPDFProperties.getInstance().addProperty("servletcontextpath", sce.getServletContext().getContextPath());

        InputStream in = getClass().getClassLoader().getResourceAsStream("topdf.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);

            for (Map.Entry prop : properties.entrySet()) {
                String propertyName = (String) prop.getKey();
                String propertyValue = (String) prop.getValue();
                ToPDFProperties.getInstance().addProperty(propertyName, propertyValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }


}
