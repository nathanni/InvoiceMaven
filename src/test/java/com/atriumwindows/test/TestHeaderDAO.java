package com.atriumwindows.test;


import com.atriumwindows.dao.HeaderDAO;
import com.atriumwindows.dao.impl.HeaderDAOImpl;
import org.junit.Test;

public class TestHeaderDAO {
  
  HeaderDAO headerDao = new HeaderDAOImpl();

  @Test
  public void test() {
    
    System.out.println(headerDao.getHeaderByInovice("50216002"));
  }

  @Test
  public void testGetInvoiceDate() {
    System.out.println(headerDao.getInvoiceDate("05000001"));
  }

}
