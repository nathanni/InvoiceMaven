package com.atriumwindows.pdf;

import com.atriumwindows.log.MyLogger;
import com.atriumwindows.utils.ToPDFProperties;
import org.apache.log4j.Logger;

import java.io.*;

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
    private static MyLogger myLogger;

    private static String savePath;
    private static String tempPath;
    private static String programPath;
    private static String servletContextPath;
    private static String sysDefParams;


    //get properties loaded
    static {
        ToPDFProperties properties = ToPDFProperties.getInstance();
        logger = Logger.getLogger(ToPDF.class);
        myLogger = new MyLogger();

        programPath = properties.getProperty("programpath");
        savePath = properties.getProperty("savepath");
        tempPath = properties.getProperty("temppath");



        String serverPath = properties.getProperty("serverpath");
        servletContextPath = serverPath + properties.getProperty("servletcontextpath"); //real path for servlet context

        String margin = properties.getProperty("margin");
        String page = properties.getProperty("page");
        String shrink = properties.getProperty("shrink");
        sysDefParams = shrink + " " + margin + " " + page; //sys parameters for wkhtmltopdf

        logger.warn("----------------------------------------------------------------------------------------------------");
        logger.warn("System properties are loaded");
        logger.warn("Program path: " + programPath);
        logger.warn("PDF save path: " + savePath);
        logger.warn("PDF temp path for generating on the fly: " + tempPath);
        logger.warn("Margin: " + margin);
        logger.warn("Page Size: " + page);
        logger.warn("Shrink :" + shrink);
        logger.warn("");

        pathValidate(savePath);
        pathValidate(tempPath);
    }

    //Validate save path and temp path. try to create if they don't exist.
    private static void pathValidate(String path) {
        File file = new File(path);
        if(!file.exists() && !file.isDirectory()) {
            if(file.mkdirs()) {
                logger.warn("Path doesn't exist, system will create this folder automatically.");
                logger.warn("Following folder is created: " + file.getPath());
                logger.warn("");
            } else {
                logger.error("System is trying to create folder");
                logger.error("Error, the folder can't be created due to some reasons: " + file.getPath());
                logger.error("");
            }
        }
    }


    public String invoiceToPDF(boolean save, String invoice, String accountId, String invoiceDate, int remit) {


        String uri = servletContextPath+ "/invoice?invoice=" + invoice;
        String outputFile;
        String params = "--header-html " + servletContextPath +  "/header.html?invoice=" + invoice + "&invoiceDate=" + invoiceDate + "&remit=" + remit;


        if(save) {
            String invoiceDateForPath = invoiceDate.replaceAll("\\/","");
            String path = savePath + accountId + "/" + invoiceDateForPath + "/";
            pathValidate(path);
            outputFile = path + "Invoice" + invoice + "_" + System.currentTimeMillis() + ".pdf";
            myLogger.hist(outputFile + " is waiting to be generated by wkhtmltopdf");
        } else {
            //better to put temporary file in temp path
            outputFile = tempPath + "invoiceTemp" + invoice + "_" + System.currentTimeMillis() + ".pdf";
        }

        executeCmd(uri, outputFile, params, save);

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
            logger.error("Errors when reading: " + outputFile);
            e.printStackTrace();
            return null;
        }
    }


    public String uriToPDF(String uri) {

        //hopefully this stops the program accessing local files.
        if(! (uri.startsWith("http://") || uri.startsWith("https://"))  ){
            uri = "http://" + uri;
        }

        String outputFile = tempPath + "temp" + System.currentTimeMillis() + ".pdf";

        String params = "--footer-center \"Page: [page] / [topage]\" --footer-line";

        executeCmd(uri, outputFile, params, false);


        return checkFile(outputFile);


    }


    //return value: 0 indicates normal termination
    private int runWkHTMLtoPDF(String params, String uri, String outputFile, boolean save) {
        Runtime rt = Runtime.getRuntime();
        Process p = null;
        int status = Integer.MIN_VALUE;


        if (save) {
            try {
                myLogger.proc("Processing by wkhtmltopdf: ");
                myLogger.proc("URI: " + uri);
                myLogger.proc("OUTPUT: " + outputFile);
                if (params == null) {
                    p = rt.exec(programPath + " " + sysDefParams + " " + uri + " " + outputFile);
                    myLogger.proc("COMMAND: " + programPath + " " + sysDefParams + " " + uri + " " + outputFile);
                } else {
                    p = rt.exec(programPath + " " + sysDefParams + " " + params + " " + uri + " " + outputFile);
                    myLogger.proc("COMMAND: " + programPath + " " + sysDefParams + " " + params + " " + uri + " " + outputFile);
                }
                status = p.waitFor();

                readProcessOutput(p);
                myLogger.proc("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (params == null) {
                    p = rt.exec(programPath + " " + sysDefParams + " " + uri + " " + outputFile);
                } else {
                    p = rt.exec(programPath + " " + sysDefParams + " " + params + " " + uri + " " + outputFile);
                }
                status = p.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return status;
    }

    private static void readProcessOutput(final Process process) {
        read(process.getInputStream());
        read(process.getErrorStream());
    }

    private static void read(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                myLogger.proc(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //return boolean value which indicates if the command is executed successfully
    private boolean executeCmd(String uri, String outputFile, String params, boolean save) {
        if(runWkHTMLtoPDF(params, uri, outputFile, save) == 0) {
            return true;
        }
        return false;
    }




}
