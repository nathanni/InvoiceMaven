package com.atriumwindows.dao.impl;

import com.atriumwindows.dao.EmailInvoiceDAO;
import com.atriumwindows.domain.Account;

import java.util.List;
import java.util.Map;

/**
 * Created by nni on 1/27/2016.
 */
public class EmailInvoiceDAOImpl extends DAOImpl<Account> implements EmailInvoiceDAO {
    @Override
    public List<Account> getAccountsForEmailInovice() {

        String sql = "SELECT a.accountid accountId, a.invemail_addr email FROM accountsmaster a WHERE a.inv_preferred_method = 'EMAIL'" +
                " AND a.accountid IN (SELECT TRIM(d.custcode) FROM dts_arimaster d WHERE d.invoice_processed IS NULL)";

        return this.getForList(sql);

    }

    @Override
    public List<Map<String, String>> getInvoiceInfoFromSpecificAccount(String accountId) {

        String sql = "SELECT invoice, invoice_date FROM dts_arimaster WHERE TRIM(custcode) = ? AND invoice_processed IS NULL";
        return this.getForMapList(sql, accountId);

    }
}
