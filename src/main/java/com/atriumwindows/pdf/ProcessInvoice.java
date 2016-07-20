package com.atriumwindows.pdf;

import com.atriumwindows.dao.EmailInvoiceDAO;
import com.atriumwindows.dao.impl.EmailInvoiceDAOImpl;
import com.atriumwindows.domain.Account;
import com.atriumwindows.log.MyLogger;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by nni on 1/27/2016.
 */
public class ProcessInvoice {


    private EmailInvoiceDAO emailInvoiceDAO = new EmailInvoiceDAOImpl();
    private static MyLogger myLogger = new MyLogger();
    private static Logger logger = Logger.getLogger(ProcessInvoice.class);

    public void processInvoice() {

        List<String> attachmentsList = null;
        Map<String, Date> invoices = null;


        // 1. get account and email address
        List<Account> accounts = emailInvoiceDAO.getAccountsForEmailInvoice();

        //invoice history log to hist.txt
        myLogger.hist("----------------------------------------------------------------------------------------------------");
        myLogger.hist("----------------------------------------------------------------------------------------------------");
        myLogger.hist("----------------------------------------------------------------------------------------------------");
        myLogger.hist("Date: " + new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date()));

        if (accounts == null || accounts.size() == 0) {
            myLogger.hist("No accounts need to be processed today, program exit");
            return;
        }

        myLogger.hist("Following " + accounts.size() + " accounts need to be processed today: ");
        myLogger.hist(accounts);


        // 2. Process invoice for email in the accounts list
        for (Account account : accounts) {
            try {
                myLogger.hist("");
                myLogger.hist("--------------------------------------------------------------------");
                myLogger.hist("--------------------------------------------------------------------");
                myLogger.hist("Processing for " + account.getAccountId());
                attachmentsList = new ArrayList<>();

                //get invoices from specific account in specific date
                invoices = emailInvoiceDAO.getInvoiceInfoFromSpecificAccount(account.getAccountId());

                if(invoices == null) {
                    myLogger.hist("No invoices list get, continue to next account");
                    continue;
                }

                StringBuilder invoiceList = new StringBuilder();
                for (String invoiceNumber : invoices.keySet()) {
                    invoiceList.append(invoiceNumber).append("   ");
                }

                myLogger.hist("Following " + invoices.size() + " invoices need to be processed: ");
                myLogger.hist(new String(invoiceList));
                myLogger.hist("--------------------------------------------------------");
                myLogger.hist("Start processing for each invoice");

                int index = 0;
                for (Map.Entry<String, Date> invoice : invoices.entrySet()) {
                    String invoiceDate = new SimpleDateFormat("MM/dd/YYYY").format(invoice.getValue());
                    int remit = invoice.getKey().matches("^5\\d+") ? 1:0; //1: TX, 0: NC

                    myLogger.hist("No. " + ++index);
                    myLogger.hist("Invoice Number: " + invoice.getKey());
                    myLogger.hist("Invoice Date: " + invoiceDate);

                    String file = ToPDF.getInstance().invoiceToPDF(true, invoice.getKey(), account.getAccountId(), invoiceDate, remit);
                    //avoid null pointer issues when sending emails
                    if (file != null) {
                        myLogger.hist("Done! The PDF file is generated");
                        attachmentsList.add(file);
                    } else {
                        myLogger.hist("Error! The PDF file is not generated for this invoice #" + invoice.getKey());
                        myLogger.hist("Check out warn.log for details");
                    }

                }

                //Send email
                myLogger.hist("--------------------------------------------------------");

                if(attachmentsList == null || attachmentsList.size() == 0) {
                    myLogger.hist("No files are generated for account: " + account.getAccountId() + ", Email won't be sent, continue to next account");
                    continue;
                }

                myLogger.hist("Sending Email for account: " + account.getAccountId());
                myLogger.hist("There is/are " + attachmentsList.size() + " invoices need to be sent via Email");
                myLogger.hist(attachmentsList);


                //title
                String title = "Invoices for " + account.getAccountId();

                //message
                StringBuffer message = new StringBuffer();
                message.append("Daily Invoices For: " + account.getAccountId()).append("\n").append("\n");
                message.append("IMPORTANT NOTE: Please do not reply to this e-mail.  If you need further assistance, please contact Atrium Accounts Receivable at (336)764-6400 or Atrium Customer Service Center at (800)846-9556").append("\n");

                SendEmail.getInstance().sendEmail(account.getEmail(), attachmentsList, title, new String(message));


                myLogger.hist("Email is sent successfully!!!! Time: " + new java.util.Date(System.currentTimeMillis()));
                myLogger.hist("Email Title: " + title);

            } catch (Exception e) {
                myLogger.hist("Encountered errors, check out error.log for details");
                logger.error(e);
                logger.error(e.getMessage());
                logger.error(e.getLocalizedMessage());
                logger.error(e.getCause());
                logger.error(Arrays.toString(e.getStackTrace()));
                e.printStackTrace();
                continue; // if there is error happened in 1 of these step, still need to continue
            }


        }

        //update invoices status from 0 to 1
        emailInvoiceDAO.updateInvoiceStatus();


    }
}
