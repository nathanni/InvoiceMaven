package com.atriumwindows.test;


import com.atriumwindows.domain.LineWrapper;
import com.atriumwindows.service.LineWrapperService;
import org.junit.Test;

import java.util.List;

public class TestLineWrapperService {
  
  LineWrapperService lineWrapperService = new LineWrapperService();
  
  @Test

  public void test() {
    List<LineWrapper> lineWrappers = lineWrapperService.getLineWrapperList("05000001");

    if(lineWrappers != null) {
      for (LineWrapper lineWrapper : lineWrappers) {
        System.out.println(lineWrapper);
      }
    }
  }
}
