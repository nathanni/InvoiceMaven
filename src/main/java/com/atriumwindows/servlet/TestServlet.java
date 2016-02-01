package com.atriumwindows.servlet;

import com.atriumwindows.pdf.ProcessInvoice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by nni on 1/14/2016.
 */
@WebServlet(name = "TestServlet" , urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProcessInvoice processInvoice = new ProcessInvoice();

        Date date = Date.valueOf("2013-01-30");
        processInvoice.processInvoice(date);
    }
}
