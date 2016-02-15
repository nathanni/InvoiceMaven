package com.atriumwindows.pdf;

import com.atriumwindows.dao.EmailInvoiceDAO;
import com.atriumwindows.dao.impl.EmailInvoiceDAOImpl;
import com.atriumwindows.domain.Account;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nni on 1/27/2016.
 */
public class ProcessInvoice {


    private EmailInvoiceDAO emailInvoiceDAO = new EmailInvoiceDAOImpl();

    public void processInvoice() {

        List<String> attachmentsList = null;
        Map<String, Date> invoices = null;


        // 1. get account and email addres
        List<Account> accounts = emailInvoiceDAO.getAccountsForEmailInvoice();

        // 2. Process invoice for email in the accounts list
        for (Account account : accounts) {
            attachmentsList = new ArrayList<>();

            //get invoices from specific account in sepecific date
            invoices = emailInvoiceDAO.getInvoiceInfoFromSpecificAccount(account.getAccountId());

            for (Map.Entry<String, Date> invoice : invoices.entrySet()) {
                String invoiceDate = new SimpleDateFormat("MM/dd/YYYY").format(invoice.getValue());
                String file = ToPDF.getInstance().invoiceToPDF(true, invoice.getKey(), invoiceDate);
                attachmentsList.add(file);
            }


            //Send email
            //title
            String title = "Invoices for " + account.getAccountId();

            //message
            StringBuffer message = new StringBuffer();
            message.append("Daily Invoices For: " + account.getAccountId()).append("\n");

            SendEmail.getInstance().sendEmail(account.getEmail(), attachmentsList, title, new String(message));

            /* LOGGER: TO DO
            *  Account, Invoices List
            * */

        }

        //update invoices status from 0 to 1
        emailInvoiceDAO.updateInvoiceStatus();


    }
}
