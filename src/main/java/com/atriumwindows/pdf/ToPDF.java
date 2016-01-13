package com.atriumwindows.pdf;

import com.atriumwindows.utils.ToPDFproperties;

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

    private static String savePath;
    private static String tempPath;
    private static String programPath;
    private static String servletContextPath;
    private static String sysDefParams;


    //get properties loaded
    static {
        ToPDFproperties properties = ToPDFproperties.getInstance();

        programPath = properties.getProperty("programpath");
        savePath = properties.getProperty("savepath");
        tempPath = properties.getProperty("temppath");

        String serverPath = properties.getProperty("serverpath");
        servletContextPath = serverPath + properties.getProperty("servletcontextpath"); //real path for servlet context

        String margin = properties.getProperty("margin");
        String page = properties.getProperty("page");
        String shrink = properties.getProperty("shrink");
        sysDefParams = margin + " " + page + " " + shrink; //sys parameters for wkhtmltopdf
    }



    public String invoiceToPDF(boolean save, String invoice, String date) {


        String uri = servletContextPath+ "/invoice?invoice=" + invoice;
        String outputFile;
        String params = "--header-html " + servletContextPath +  "/header.html?invoice=" + invoice + "&invoiceDate=" + date;

        if(save) {
            outputFile = savePath + "Invoice" + invoice + "Time" + System.currentTimeMillis() + ".pdf";
            runWkHTMLtoPDF(params,uri,outputFile);
        } else {
            outputFile = tempPath + "invoiceTemp" + invoice + "Time" + System.currentTimeMillis() + ".pdf";
        }

        return outputFile;

    }



    public String uriToPDF(String uri) {

        if(uri == null || uri.isEmpty()) return null;

        //hopefully this stops the program accessing local files.
        if(! (uri.startsWith("http://") || uri.startsWith("https://"))  ){
            uri = "http://" + uri;
        }


        String outputFile = tempPath + "temp" + System.currentTimeMillis() + ".pdf";

        runWkHTMLtoPDF(null, uri, outputFile);

        downloadFile(outputFile);

        return outputFile;

    }

    private void downloadFile(String outputFile) {
        System.out.println("downloading");


    }

    private Process runWkHTMLtoPDF(String params, String uri, String outputFile) {
        Runtime rt = Runtime.getRuntime();
        Process p = null;

        try {
            if(params == null )
                p = rt.exec(programPath + " " + sysDefParams + " " + uri + " " + outputFile);
            else
                p = rt.exec(programPath + " " + sysDefParams + " " + params + " " + uri + " " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }







}
