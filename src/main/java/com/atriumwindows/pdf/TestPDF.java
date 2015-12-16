package com.atriumwindows.pdf;

import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by nni on 12/16/2015.
 */
public class TestPDF {
    public static void main(String[] args) {
        String url = "http://localhost:8080/invoice?invoice=03669241";
        //String url = "file:///C:/Users/nni/Downloads/New%20folder%20(2)/New%20folder%20(2)/Invoice.html";
        create(url);
    }
    public static void create(final String url) {
        try {

            /** Creating an instance of iText renderer
             *  which will be used to generate the pdf from the
             *  html document.
             */
            final ITextRenderer iTextRenderer = new ITextRenderer();
            /**
             * Setting the document as the url value passed.
             * This means that the iText renderer
             * has to parse this html document to generate the pdf.
             */
            iTextRenderer.setDocument(url);
            iTextRenderer.layout();

            /** The generated pdf will be written
             to the invoice.pdf file. */
            final FileOutputStream fileOutputStream =
                    new FileOutputStream(new File("invoice.pdf"));

            /** Creating the pdf and
             writing it in invoice.pdf file. */
            iTextRenderer.createPDF(fileOutputStream);
            fileOutputStream.close();

        } catch (final DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
