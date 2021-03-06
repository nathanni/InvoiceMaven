package com.atriumwindows.service;

import com.atriumwindows.dao.LineDAO;
import com.atriumwindows.dao.LineWrapperDAO;
import com.atriumwindows.dao.impl.LineDAOImpl;
import com.atriumwindows.dao.impl.LineWrapperDAOImpl;
import com.atriumwindows.domain.Line;
import com.atriumwindows.domain.LineWrapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LineWrapperService {
  
  private LineDAO lineDAO = new LineDAOImpl();
  private LineWrapperDAO lineWrapperDAO = new LineWrapperDAOImpl();
  
  
  public List<LineWrapper> getLineWrapperList(String invoice) {
    
    List<Line> lines = lineDAO.getLinesByInvoice(invoice);
    List<LineWrapper> lineWrappers = new ArrayList<LineWrapper>();
    LineWrapper lineWrapper = null;



//    //if lines are not from l1 and l2
//    if(lines == null || lines.size() == 0) {
//      lines = lineDAO.getLinesByInvoiceWithoutL1L2(invoice);
//      if(lines == null || lines.size() == 0) return null; //no lines get
//      for(Line line : lines) {
//        lineDAO.handleDescWithoutL1L2(line);
//        lineWrapper = new LineWrapper();
//        lineWrapper.setConfigLine(null);
//        lineWrapper.getLines().add(line);
//        lineWrappers.add(lineWrapper);
//      }
//
//      return lineWrappers;
//    }




    HashSet validateSet = new HashSet();
    
    //group lines to linewrapper base on itemid
    for(Line line : lines) {
      
      lineDAO.handleSize(line);
      lineDAO.handleDesc(line);
      
//      if(validateSet.add(line.getItemId())) {
//        if(lineWrapper != null) lineWrappers.add(lineWrapper);
//        lineWrapper = new LineWrapper();
//      }

      //use wwline instead of itemid to group lines
      if(validateSet.add(line.getWwLine())) {
        if(lineWrapper != null) lineWrappers.add(lineWrapper);
        lineWrapper = new LineWrapper();
      }
      
      lineWrapperDAO.addLinesToLineWrapper(lineWrapper, line);
    }
    if(lineWrapper != null) lineWrappers.add(lineWrapper); //add last line


    return lineWrappers;
    
  }

}
