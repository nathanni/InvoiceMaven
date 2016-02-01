package com.atriumwindows.dao;

import com.atriumwindows.domain.Account;

import java.sql.Date;
import java.util.List;

/**
 * Created by nni on 1/27/2016.
 */
public interface EmailInvoiceDAO {


    List<Account> getAccountsForEmailInvoice(Date date);

/*    Map<String, String> getInvoiceInfoFromSpecificAccount(String accountId, Date date);*/

    List<String> getInvoicesFromSpecificAccount(String accountId, Date date);

}
