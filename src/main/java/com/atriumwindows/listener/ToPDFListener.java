package com.atriumwindows.listener; /**
 * Created by Nathan on 1/13/2016.
 */

import com.atriumwindows.utils.ToPDFproperties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

@WebListener()
public class ToPDFListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public ToPDFListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        //load Servlet Context Path
        ToPDFproperties.getInstance().addProperty("servletcontextpath", sce.getServletContext().getContextPath());

        InputStream in = getClass().getClassLoader().getResourceAsStream("topdf.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);

            for (Map.Entry prop : properties.entrySet()) {
                String propertyName = (String) prop.getKey();
                String propertyValue = (String) prop.getValue();
                ToPDFproperties.getInstance().addProperty(propertyName, propertyValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }


}
