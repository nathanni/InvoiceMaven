package com.atriumwindows.test;

import com.atriumwindows.dao.EmailInvoiceDAO;
import com.atriumwindows.dao.impl.EmailInvoiceDAOImpl;
import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by nni on 1/27/2016.
 */
public class TestAccountDAO {
    EmailInvoiceDAO accountDAO = new EmailInvoiceDAOImpl();

    @Test
    public void test() {

        //get yesterday's date
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DATE, -1);
        c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);


        Date date = new Date(c.getTime().getTime());
        System.out.println(date);

//       List<Account> accounts = accountDAO.getAccountsForEmailInovice(Date.valueOf("2013-01-30"));
//        System.out.println(accounts);

    }

    @Test
    public void test1() {

        System.out.println(accountDAO.getInvoicesFromSpecificAccount("AB0270", Date.valueOf("2013-01-30")));

    }

}
