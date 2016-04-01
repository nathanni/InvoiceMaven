package com.atriumwindows.dao;

import com.atriumwindows.domain.Line;
import java.util.List;

public interface LineDAO {

  List<Line> getLinesByInvoice(String invoice);

  void handleSize(Line line);
  
  void handleDesc(Line line);

  /* New fields are passed from CAELUS, we don't need to query L1_ITEM and L2_UNIT*/

  //List<Line> getLinesByInvoiceWithoutL1L2(String invoice);
  //void handleDescWithoutL1L2(Line line);

}
