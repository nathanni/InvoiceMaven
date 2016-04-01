package com.atriumwindows.domain;

public class Line {
  
  private int lineTypeId;
  private String muType;
  private int seqNo;
  private String partNumber;
  private String partDesc;
  private String skuNumber;
  private Double unitPrice;
  private Double extensionPrice;
  private Double discount;
  private int orderQty;
  private int shippedQty;
  private String itemId;
  private String unitId;
  
  private String lineDesc;
  private String l1Desc;
  private String l2Desc;
  
  private String sizeCode;
  private String size;
  private String sizeNS;
  private String sizeES;

  private Integer wwLine;

  public Integer getWwLine() {
    return wwLine;
  }

  public void setWwLine(Integer wwLine) {
    this.wwLine = wwLine;
  }

  public int getLineTypeId() {
    return lineTypeId;
  }

  public void setLineTypeId(int lineTypeId) {
    this.lineTypeId = lineTypeId;
  }

  public String getMuType() {
    return muType;
  }

  public void setMuType(String muType) {
    this.muType = muType;
  }

  public int getSeqNo() {
    return seqNo;
  }

  public void setSeqNo(int seqNo) {
    this.seqNo = seqNo;
  }

  public String getPartNumber() {
    return partNumber;
  }

  public void setPartNumber(String partNumber) {
    this.partNumber = partNumber;
  }

  public String getPartDesc() {
    return partDesc;
  }

  public void setPartDesc(String partDesc) {
    this.partDesc = partDesc;
  }

  public String getSkuNumber() {
    return skuNumber;
  }

  public void setSkuNumber(String skuNumber) {
    this.skuNumber = skuNumber;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Double getExtensionPrice() {
    return extensionPrice;
  }

  public void setExtensionPrice(Double extensionPrice) {
    this.extensionPrice = extensionPrice;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public int getOrderQty() {
    return orderQty;
  }

  public void setOrderQty(int orderQty) {
    this.orderQty = orderQty;
  }

  public int getShippedQty() {
    return shippedQty;
  }

  public void setShippedQty(int shippedQty) {
    this.shippedQty = shippedQty;
  }

  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public String getUnitId() {
    return unitId;
  }

  public void setUnitId(String unitId) {
    this.unitId = unitId;
  }

  public String getLineDesc() {
    return lineDesc;
  }

  public void setLineDesc(String lineDesc) {
    this.lineDesc = lineDesc;
  }

  public String getL1Desc() {
    return l1Desc;
  }

  public void setL1Desc(String l1Desc) {
    this.l1Desc = l1Desc;
  }

  public String getL2Desc() {
    return l2Desc;
  }

  public void setL2Desc(String l2Desc) {
    this.l2Desc = l2Desc;
  }

  public String getSizeCode() {
    return sizeCode;
  }

  public void setSizeCode(String sizeCode) {
    this.sizeCode = sizeCode;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getSizeNS() {
    return sizeNS;
  }

  public void setSizeNS(String sizeNS) {
    this.sizeNS = sizeNS;
  }

  public String getSizeES() {
    return sizeES;
  }

  public void setSizeES(String sizeES) {
    this.sizeES = sizeES;
  }

  public Line() {
  }

  public Line(int shippedQty, String lineDesc) {
    this.shippedQty = shippedQty;
    this.lineDesc = lineDesc;
  }


  @Override
  public String toString() {
    return "Line{" +
            "lineTypeId=" + lineTypeId +
            ", muType='" + muType + '\'' +
            ", seqNo=" + seqNo +
            ", partNumber='" + partNumber + '\'' +
            ", partDesc='" + partDesc + '\'' +
            ", skuNumber='" + skuNumber + '\'' +
            ", unitPrice=" + unitPrice +
            ", extensionPrice=" + extensionPrice +
            ", discount=" + discount +
            ", orderQty=" + orderQty +
            ", shippedQty=" + shippedQty +
            ", itemId='" + itemId + '\'' +
            ", unitId='" + unitId + '\'' +
            ", lineDesc='" + lineDesc + '\'' +
            ", l1Desc='" + l1Desc + '\'' +
            ", l2Desc='" + l2Desc + '\'' +
            ", sizeCode='" + sizeCode + '\'' +
            ", size='" + size + '\'' +
            ", sizeNS='" + sizeNS + '\'' +
            ", sizeES='" + sizeES + '\'' +
            ", wwLine=" + wwLine +
            '}';
  }
}
