package com.atriumwindows.servlet;

import com.atriumwindows.domain.Header;
import com.atriumwindows.domain.LineWrapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by nni on 12/11/2015.
 */
@javax.servlet.annotation.WebServlet(name = "invoice")
public class InvoiceServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String invoice = request.getParameter("invoice").trim();
        if(invoice != null && !"".equals(invoice)) {
            Header header = headerDAO.getHeaderByInovice(invoice);
            List<LineWrapper> lineWrappers = lineWrapperService.getLineWrapperList(invoice);
            System.out.println(header);
            System.out.println(lineWrappers);
            request.setAttribute("header", header);
            request.setAttribute("lines", lineWrappers);
            request.getRequestDispatcher("/WEB-INF/pages/invoice.jsp").forward(request, response);
            return;
        }

        String errors = "Invoice not found";
        request.setAttribute("error" ,errors);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
