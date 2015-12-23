package com.atriumwindows.servlet;


import com.atriumwindows.domain.Header;
import com.atriumwindows.domain.LineWrapper;
import com.atriumwindows.service.HeaderService;
import com.atriumwindows.service.LineWrapperService;

import java.io.IOException;
import java.util.List;

/**
 * Created by nni on 12/11/2015.
 */
@javax.servlet.annotation.WebServlet(name = "invoice", urlPatterns = {"/invoice"})
public class InvoiceServlet extends javax.servlet.http.HttpServlet {

    private HeaderService headerService = new HeaderService();
    private LineWrapperService lineWrapperService = new LineWrapperService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String invoiceParam = request.getParameter("invoice");
        if(invoiceParam != null) {
            String invoice = invoiceParam.trim();
            if (invoice != null && !"".equals(invoice)) {
                Header header = headerService.getHeader(invoice);
                List<LineWrapper> lineWrappers = lineWrapperService.getLineWrapperList(invoice);
                if(header != null && lineWrappers != null) {
                    request.setAttribute("header", header);
                    request.setAttribute("lines", lineWrappers);
                    request.getRequestDispatcher("/WEB-INF/pages/invoice.jsp").forward(request, response);
                    return;
                }
            }
        }


        String errors = "Invoice not found";
        request.setAttribute("error", errors);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if(request.getParameter("invoice") == null || request.getParameter("invoice") == "") {
            response.sendRedirect("/index.jsp");
            return;
        }
        request.setAttribute("getPage", true); //this value is for hide header, if the request is from GET(pdf side)
        doPost(request, response);
    }
}
