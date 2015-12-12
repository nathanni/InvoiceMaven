package com.atriumwindows.dao.impl;

import com.atriumwindows.dao.LineWrapperDAO;
import com.atriumwindows.domain.Line;
import com.atriumwindows.domain.LineWrapper;

public class LineWrapperDAOImpl extends DAOImpl<LineWrapper> implements LineWrapperDAO{

  private static final int INITIAL = 0;
  private static final int MULLED_UNIT = 3;
  private static final int BAY_BOW = 4;
  
  @Override
  public boolean addLinesToLineWrapper(LineWrapper lineWrapper, Line line) {
    if(lineWrapper != null && line != null) {
      
      //mull unit, need to set configuration line
      if((line.getLineTypeId() == 3 || line.getMuType() != null) && lineWrapper.getLineType() == INITIAL) {
        lineWrapper.setLineType(MULLED_UNIT);
        lineWrapper.setConfigLine((new Line(line.getOrderQty(), line.getShippedQty(), line.getL1Desc())));
      }
      
      if(line.getLineTypeId() == 4 && lineWrapper.getLineType() == INITIAL) {
        lineWrapper.setLineType(BAY_BOW);
      }
      
      lineWrapper.getLines().add(line);
      return true;
    }
    return false;
    
  }

  

}
