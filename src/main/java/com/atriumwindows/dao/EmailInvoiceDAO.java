package com.atriumwindows.dao;

import com.atriumwindows.domain.Account;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by nni on 1/27/2016.
 */
public interface EmailInvoiceDAO {


    List<Account> getAccountsForEmailInvoice();

    Map<String, Date> getInvoiceInfoFromSpecificAccount(String accountId);

    List<String> getInvoicesFromSpecificAccount(String accountId);

    List<String> getInvoicesNeedToBeProcessed();

    void updateInvoiceStatus();


}
