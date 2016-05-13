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

            try {
                attachmentsList = new ArrayList<>();

                //get invoices from specific account in sepecific date
                invoices = emailInvoiceDAO.getInvoiceInfoFromSpecificAccount(account.getAccountId());

                if(invoices == null) continue;

                for (Map.Entry<String, Date> invoice : invoices.entrySet()) {
                    String invoiceDate = new SimpleDateFormat("MM/dd/YYYY").format(invoice.getValue());
                    int remit = invoice.getKey().matches("^5\\d+") ? 1:0; //1: TX, 0: NC
                    String file = ToPDF.getInstance().invoiceToPDF(true, invoice.getKey(), invoiceDate, remit);
                    //avoid null pointer issues when sending emails
                    if (file != null) {
                        attachmentsList.add(file);
                    }
                }


                //Send email
                //title
                String title = "Invoices for " + account.getAccountId();

                //message
                StringBuffer message = new StringBuffer();
                message.append("Daily Invoices For: " + account.getAccountId()).append("\n").append("\n");
                message.append("IMPORTANT NOTE: Please do not reply to this e-mail.  If you need further assistance, please contact Atrium Accounts Receivable at (336)764-6400 or Atrium Customer Service Center at (800)846-9556").append("\n");

                SendEmail.getInstance().sendEmail(account.getEmail(), attachmentsList, title, new String(message));

                System.out.println("Email sent !!!! Time: " + new java.util.Date(System.currentTimeMillis()));
                System.out.println("Title: " + title);

            /* LOGGER: TO DO
            *  Account, Invoices List
            * */
            } catch (Exception e) {
                System.out.println("------------------errors in sending email------------------");
                e.printStackTrace();
                continue; // if there is error happened in 1 of these step, still need to continue
            }


        }

        //update invoices status from 0 to 1
        emailInvoiceDAO.updateInvoiceStatus();


    }
}
