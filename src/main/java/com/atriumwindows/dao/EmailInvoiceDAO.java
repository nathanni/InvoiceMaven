package com.atriumwindows.dao;

import com.atriumwindows.domain.Account;

import java.util.List;
import java.util.Map;

/**
 * Created by nni on 1/27/2016.
 */
public interface EmailInvoiceDAO {


    List<Account> getAccountsForEmailInovice();

    List<Map<String, String>> getInvoiceInfoFromSpecificAccount(String accountId);

}
