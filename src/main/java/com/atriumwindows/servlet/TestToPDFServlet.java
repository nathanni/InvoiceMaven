package com.atriumwindows.servlet;

import com.atriumwindows.pdf.ToPDF;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by nni on 1/7/2016.
 */
@WebServlet(name = "TestToPDFServlet", urlPatterns = {"/topdf1"})
public class TestToPDFServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ToPDF toPDF = ToPDF.getInstance();
        String invoice = request.getParameter("invoice");
        String filename = toPDF.invoiceToPDF(true, invoice, "20101010");
        if(filename != null) {
            request.setAttribute("filename", filename);
            request.getRequestDispatcher("/download").forward(request,response);
        }
        return;

    }
}
