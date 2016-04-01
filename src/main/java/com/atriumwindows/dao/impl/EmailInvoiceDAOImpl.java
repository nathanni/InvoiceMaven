package com.atriumwindows.dao.impl;

import com.atriumwindows.dao.EmailInvoiceDAO;
import com.atriumwindows.domain.Account;
import com.atriumwindows.utils.DBConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nni on 1/27/2016.
 */
public class EmailInvoiceDAOImpl extends DAOImpl<Account> implements EmailInvoiceDAO {
    @Override
    public List<Account> getAccountsForEmailInvoice() {

        String sql = "SELECT a.accountid accountId, a.invemail_addr email FROM accountsmaster a WHERE a.inv_preferred_method = 4 AND a.invemail_addr IS NOT NULL" +
                " AND a.accountid IN (SELECT TRIM(d.custcode) FROM dts_arimaster d WHERE d.invoice_processed = 0)";
        return this.getForList(sql);

    }


    //get Invoice and InvoiceDate pair
    @Override
    public Map<String, Date> getInvoiceInfoFromSpecificAccount(String accountId) {
        String sql = "SELECT invoice, invoice_date FROM dts_arimaster WHERE TRIM(custcode) = ? AND invoice_processed = 0";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Map<String, Date> map = new HashMap<>();
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                map.put(resultSet.getString("invoice"), resultSet.getDate("invoice_date"));
            }
            return map;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.releaseConnection(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public List<String> getInvoicesFromSpecificAccount(String accountId) {
        String sql = "SELECT invoice FROM dts_arimaster WHERE TRIM(custcode) = ? AND invoice_processed = 0";
        return this.getForValueList(sql, accountId);
    }

    @Override
    public List<String> getInvoicesNeedToBeProcessed() {
        String sql = "SELECT invoice FROM dts_arimaster WHERE invoice_processed = 0";
        return this.getForValueList(sql);
    }

    @Override
    public void updateInvoiceStatus() {
        String sql = "UPDATE dts_arimaster SET invoice_processed = 1 WHERE invoice_processed = 0";
        this.update(sql);
    }




}
