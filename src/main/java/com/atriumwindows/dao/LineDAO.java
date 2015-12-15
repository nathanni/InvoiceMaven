package com.atriumwindows.dao;

import com.atriumwindows.domain.Line;
import java.util.List;

public interface LineDAO {
  
  List<Line> getLinesByInvoice(String invoice);

  List<Line> getLinesByInoivceWithoutL1L2(String invoice);
  
  void handleSize(Line line);
  
  void handleDesc(Line line);

  void handleDescWithoutL1L2(Line line);
}
