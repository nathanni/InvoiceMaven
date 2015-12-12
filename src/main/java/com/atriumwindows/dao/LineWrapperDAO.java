package com.atriumwindows.dao;

import com.atriumwindows.domain.Line;
import com.atriumwindows.domain.LineWrapper;

public interface LineWrapperDAO {
  
  boolean addLinesToLineWrapper(LineWrapper lineWrapper, Line line);
  
}
