package com.atriumwindows.servlet;

import com.atriumwindows.pdf.ToPDF;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Servlet API to convert URI to PDF
 * Created by nni on 1/13/2016.
 */
@WebServlet(name = "UriToPDFServlet", urlPatterns = {"/topdf"})
public class UriToPDFServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getParameter("uri");
        ToPDF toPDF = ToPDF.getInstance();
        String filename = toPDF.uriToPDF(uri);
        request.setAttribute("filename",filename );
        request.getRequestDispatcher("/downloadtest.jsp").forward(request,response);


    }
}
