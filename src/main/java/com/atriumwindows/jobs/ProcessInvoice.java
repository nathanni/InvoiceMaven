package com.atriumwindows.jobs;

import com.atriumwindows.dao.EmailInvoiceDAO;
import com.atriumwindows.dao.impl.EmailInvoiceDAOImpl;
import com.atriumwindows.domain.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nni on 1/27/2016.
 */
public class ProcessInvoice {


    private EmailInvoiceDAO accountDAO = new EmailInvoiceDAOImpl();
    public void processInvoice() {

        List<String> attachmentsList = null;
        List<Map<String,String>> invoices = null;


        // 1. get account and email addres

        List<Account> accounts = accountDAO.getAccountsForEmailInovice();

        // 2. Process invoice for email in the accounts list

        for(Account account: accounts) {
            attachmentsList = new ArrayList<>();

            invoices = accountDAO.getInvoiceInfoFromSpecificAccount(account.getAccountId());

            for(Map<String, String> invoice: invoices) {

                //String filename = ToPDF.getInstance().invoiceToPDF(true, invoice.)

            }



        }



    }
}
