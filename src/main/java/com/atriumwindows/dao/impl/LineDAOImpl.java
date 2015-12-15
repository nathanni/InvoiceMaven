package com.atriumwindows.dao.impl;

import com.atriumwindows.dao.LineDAO;
import com.atriumwindows.domain.Line;

import java.util.List;

public class LineDAOImpl extends DAOImpl<Line> implements LineDAO{

  @Override
  public List<Line> getLinesByInvoice(String invoice) {

    String sql = "SELECT TRIM(l1.description) l1Desc, TRIM(l2.description) l2Desc, l1.linetypeid lineTypeId, "
        + "l1.mutype muType, l.seq_no seqNo, TRIM(l.part_no) partNumber, TRIM(l.part_desc) partDesc, "
        + "TRIM(l.skunumber) skuNumber, l.price_unit_price unitPrice, "
        + "l.extension extensionPrice, l.line_disc discount, l.order_qty orderQty, l.shipped_qty shippedQty, l.itemId, l.unitId, "
        + "l2.sizecode sizeCode, l2.widthns || '\" x ' || l2.heightns || '\" NS' sizeNS, l2.widthes || '\" x ' || l2.heightes || '\" ES' sizeES "
        + "FROM dts_arilines l, l2_unit l2, l1_item l1 WHERE invoice = ? AND "
        + "l2.unitid = l.unitid AND l.itemid = l1.itemid ORDER BY SEQ_NO";

    return this.getForList(sql, invoice);
  }

  @Override
  public List<Line> getLinesByInoivceWithoutL1L2(String invoice) {
    String sql = "SELECT l.seq_no seqNo, TRIM(l.part_no) partNumber, TRIM(l.part_desc) partDesc, "
            + "TRIM(l.skunumber) skuNumber, l.price_unit_price unitPrice, "
            + "l.extension extensionPrice, l.line_disc discount, l.order_qty orderQty, l.shipped_qty shippedQty, l.itemId, l.unitId "
            + "FROM dts_arilines l WHERE invoice = ? ORDER BY SEQ_NO";
    return this.getForList(sql, invoice);
  }

  @Override
  public void handleSize(Line line) {

    if(line.getSizeCode() != null && line.getSizeCode().equalsIgnoreCase("NS")) {
      line.setSize(line.getSizeNS());
    } else if(line.getSizeCode() != null && (line.getSizeCode().equalsIgnoreCase("OS") || line.getSizeCode().equalsIgnoreCase("ES"))) {
      line.setSize(line.getSizeES());
    } else {
      line.setSize("NO SIZE");
    }
    line.setSizeES(null);
    line.setSizeNS(null);
  }

  public void handleDesc(Line line) {

    //handle baybow description
    if(line.getLineTypeId() == 4) {
      line.setLineDesc((line.getL2Desc()==null?"":line.getL2Desc()) + " " + (line.getL1Desc()==null?"":line.getL1Desc()));
    } else {
      line.setLineDesc(line.getL2Desc());
    }
    line.setL2Desc(null);
    //need to keep L1Desc to build configLine
  }

  @Override
  public void handleDescWithoutL1L2(Line line) {
    //no data exsits in L1_item and L2_unit, create desc by partNum + partDesc + SKU
    line.setLineDesc((line.getPartNumber()==null?"":line.getPartNumber()) + " " + (line.getPartDesc()==null?"":line.getPartDesc())
            + " " + (line.getSkuNumber() == null ?"":line.getSkuNumber()));
  }

}
