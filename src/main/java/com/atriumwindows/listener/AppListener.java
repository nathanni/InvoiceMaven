package com.atriumwindows.listener; /**
 * Created by Nathan on 1/13/2016.
 */

import com.atriumwindows.job.DailyInvoice;
import com.atriumwindows.utils.EmailProperties;
import com.atriumwindows.utils.ToPDFProperties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@WebListener()
public class AppListener implements ServletContextListener {

    private ScheduledExecutorService scheduler;

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


        //run task everyday at "jobtime"
        String jobtime = EmailProperties.getInstance().getProperty("jobtime");
        scheduler = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay  = getTimeMillis(jobtime) - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;
        scheduler.scheduleAtFixedRate(new DailyInvoice(), initDelay, oneDay, TimeUnit.MILLISECONDS);


    }

    //get millis time for specific time
    private static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
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
        scheduler.shutdownNow();
    }


}
