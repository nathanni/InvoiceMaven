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
    HashSet validateSet = new HashSet();
    
    //group lines to linewrapper base on itemid
    for(Line line : lines) {
      
      lineDAO.handleSize(line);
      lineDAO.handleDesc(line);
      
      if(validateSet.add(line.getItemId())) {
        if(lineWrapper != null) lineWrappers.add(lineWrapper);
        lineWrapper = new LineWrapper();
      }
      
      lineWrapperDAO.addLinesToLineWrapper(lineWrapper, line);
    }
    if(lineWrapper != null) lineWrappers.add(lineWrapper); //add last line

   
    
    
    return lineWrappers;
    
  }

}
