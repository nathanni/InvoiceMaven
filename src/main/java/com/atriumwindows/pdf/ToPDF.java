package com.atriumwindows.pdf;

import com.atriumwindows.utils.ToPDFProperties;
import org.apache.log4j.Logger;
import java.io.File;

/**
 * Created by nni on 1/7/2016.
 */
public class ToPDF {

    //singleton
    private ToPDF(){}
    private static final ToPDF instance = new ToPDF();
    public static ToPDF getInstance() {
        return instance;
    }

    private static Logger logger;

    private static String savePath;
    private static String tempPath;
    private static String programPath;
    private static String servletContextPath;
    private static String sysDefParams;


    //get properties loaded
    static {
        ToPDFProperties properties = ToPDFProperties.getInstance();
        logger = Logger.getLogger(ToPDF.class);

        programPath = properties.getProperty("programpath");
        savePath = properties.getProperty("savepath");
        tempPath = properties.getProperty("temppath");

        pathValidate(savePath);
        pathValidate(tempPath);

        String serverPath = properties.getProperty("serverpath");
        servletContextPath = serverPath + properties.getProperty("servletcontextpath"); //real path for servlet context

        String margin = properties.getProperty("margin");
        String page = properties.getProperty("page");
        String shrink = properties.getProperty("shrink");
        sysDefParams = shrink + " " + margin + " " + page; //sys parameters for wkhtmltopdf
    }

    //Validate save path and temp path. try to create if they don't exist.
    private static void pathValidate(String path) {
        File file = new File(path);
        if(!file.exists() && !file.isDirectory()) {
            if(file.mkdirs()) {
                logger.warn("Path doesn't exist, system will create this folder automatically.");
                logger.warn("Folder is created: " + file.getPath());
            } else {
                logger.error("System is trying to create folder");
                logger.error("Error, the folder can't be created due to some reasons: " + file.getPath());
            }
        }
    }


    public String invoiceToPDF(boolean save, String invoice, String invoiceDate, int remit) {


        String uri = servletContextPath+ "/invoice?invoice=" + invoice;
        String outputFile;
        String params = "--header-html " + servletContextPath +  "/header.html?invoice=" + invoice + "&invoiceDate=" + invoiceDate + "&remit=" + remit;

        if(save) {
            outputFile = savePath + "Invoice" + invoice + "_" + System.currentTimeMillis() + ".pdf";
        } else {
            //better to put temporary file in temp path
            outputFile = tempPath + "invoiceTemp" + invoice + "_" + System.currentTimeMillis() + ".pdf";
        }

        if (executeCmd(uri, outputFile, params)) return outputFile;

        return checkFile(outputFile);
    }

    private String checkFile(String outputFile) {
        try {
            File file = new File(outputFile);
            if(file.exists()) {
                return outputFile;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Errors when reading: " + outputFile);
            return null;
        }
    }


    public String uriToPDF(String uri) {

        //hopefully this stops the program accessing local files.
        if(! (uri.startsWith("http://") || uri.startsWith("https://"))  ){
            uri = "http://" + uri;
        }

        String outputFile = tempPath + "temp" + System.currentTimeMillis() + ".pdf";

        if (executeCmd(uri, outputFile, null)) return outputFile;


        return checkFile(outputFile);


    }


    //return value: 0 indicates normal termination
    private int runWkHTMLtoPDF(String params, String uri, String outputFile) {
        Runtime rt = Runtime.getRuntime();
        Process p = null;
        int status = Integer.MIN_VALUE;

        try {
            if(params == null )
                p = rt.exec(programPath + " " + sysDefParams + " " + uri + " " + outputFile);
            else
                p = rt.exec(programPath + " " + sysDefParams + " " + params + " " + uri + " " + outputFile);
            status = p.waitFor();

            /*  LOGGER: TO DO */


        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    //return boolean value which indicates if the command is excuted successfully
    private boolean executeCmd(String uri, String outputFile, String params) {
        if(runWkHTMLtoPDF(params,uri,outputFile) == 0) {
            return true;
        }
        return false;
    }




}
