package com.atriumwindows.servlet;

import com.atriumwindows.pdf.ToPDF;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * ToPDF Servlet API
 * Created by Nathan on 1/14/2016.
 */
@WebServlet(name = "ToPDFServlet", urlPatterns = {"*.do"})
public class ToPDFServlet extends HttpServlet {

    private ToPDF toPDF = ToPDF.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String methodString = request.getServletPath().replaceAll("^\\/", "").replaceAll(".do\\b", "");
        try {
            Method method = getClass().getDeclaredMethod(methodString,
                    HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //API to convert uri to pdf
    private void topdf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getParameter("uri");
        //validate uri
        if (uri == null || uri.isEmpty()) return;
        String filename = toPDF.uriToPDF(uri);
        downloadFile(request, response, filename);
        return;
    }

    //convert invoice to pdf
    private void invoicetopdf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String invoice = request.getParameter("invoice");
        String invoiceDate = request.getParameter("invoicedate");
        String filename = toPDF.invoiceToPDF(false, invoice, invoiceDate);
        downloadFile(request, response, filename);
        return;
    }

    private void downloadFile(HttpServletRequest request, HttpServletResponse response, String filename) throws ServletException, IOException {
        if(filename != null) {
            request.setAttribute("filename", filename);
            request.getRequestDispatcher("/download").forward(request,response);
        }
    }
}
