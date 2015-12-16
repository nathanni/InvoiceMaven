package com.atriumwindows.test;


import com.atriumwindows.dao.HeaderDAO;
import com.atriumwindows.dao.impl.HeaderDAOImpl;
import org.junit.Test;

public class TestHeaderDAO {
  
  HeaderDAO headerDao = new HeaderDAOImpl();

  @Test
  public void test() {
    
    System.out.println(headerDao.getHeaderByInovice("05000001"));
  }

}
