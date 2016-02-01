package com.atriumwindows.dao.impl;

import com.atriumwindows.dao.EmailInvoiceDAO;
import com.atriumwindows.domain.Account;

import java.sql.Date;
import java.util.List;

/**
 * Created by nni on 1/27/2016.
 */
public class EmailInvoiceDAOImpl extends DAOImpl<Account> implements EmailInvoiceDAO {
    @Override
    public List<Account> getAccountsForEmailInvoice(Date date) {

        String sql = "SELECT a.accountid accountId, a.invemail_addr email FROM accountsmaster a WHERE a.inv_preferred_method = 'EMAIL'" +
                " AND a.accountid IN (SELECT TRIM(d.custcode) FROM dts_arimaster d WHERE d.invoice_date = ?)";
        return this.getForList(sql, date);

    }


    //get Invoice and InvoiceDate pair
/*    @Override
    public Map<String, String> getInvoiceInfoFromSpecificAccount(String accountId, Date date) {
        String sql = "SELECT invoice, invoice_date FROM dts_arimaster WHERE TRIM(custcode) = ? AND invoice_date = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Map<String, String> map = new HashMap<>();
        try {
            connection = DBConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, accountId);
            preparedStatement.setDate(2, date);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                map.put(resultSet.getString("invoice"), resultSet.getString("invoice_date"));
            }
            return map;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.releaseConnection(connection, preparedStatement, resultSet);
        }
        return null;
    }*/

    @Override
    public List<String> getInvoicesFromSpecificAccount(String accountId, Date date) {
        String sql = "SELECT invoice FROM dts_arimaster WHERE TRIM(custcode) = ? AND invoice_date = ?";
        return this.getForValueList(sql, accountId, date);
    }
}
