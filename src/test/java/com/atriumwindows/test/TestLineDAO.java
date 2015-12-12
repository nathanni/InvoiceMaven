package com.atriumwindows.test;


import com.atriumwindows.dao.LineDAO;
import com.atriumwindows.dao.impl.LineDAOImpl;
import com.atriumwindows.domain.Line;
import org.junit.Test;

public class TestLineDAO {
  
  LineDAO lineDAO = new LineDAOImpl();
  
  
  @Test
  public void test() {
    java.util.List<Line> lines = lineDAO.getLinesByInvoice("05000001");
    
    for(Line line: lines) {
      System.out.println(line);
    }
  }

}
