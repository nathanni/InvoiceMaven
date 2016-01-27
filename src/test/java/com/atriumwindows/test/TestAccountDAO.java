package com.atriumwindows.test;

import com.atriumwindows.dao.EmailInvoiceDAO;
import com.atriumwindows.dao.impl.EmailInvoiceDAOImpl;
import org.junit.Test;

/**
 * Created by nni on 1/27/2016.
 */
public class TestAccountDAO {
    EmailInvoiceDAO accountDAO = new EmailInvoiceDAOImpl();

    @Test
    public void test() {



        System.out.println(accountDAO.getAccountsForEmailInovice());

    }

    @Test
    public void test1() {
        System.out.println(accountDAO.getInvoiceInfoFromSpecificAccount("AA0108"));
    }

}
