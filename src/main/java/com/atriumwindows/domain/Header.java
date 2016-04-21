package com.atriumwindows.domain;

import java.sql.Date;

public class Header {
  
  private String invoice;
  private Date invoiceDate;
  //private double cashDiscPct;
  //private Date discTerms;
  //private Date netTerms;
  private String termsCode;
  private String termsDesc;
  private String purchaseOrder;
  private String salesOrder;
  private String billOfLading;
  private String howShip;
  private String fob;
  private String jobName;
  private String approvalNeeded;
  private String approvalCode;
  private String customerCode;
  private String loadNumber;



  private String shipToAddr1;
  private String shipToAddr2;
  private String shipToAddr3;
  private String shipToAddr4;
  private String shipToAddr5;
  private String shipToAddr6;
  
  private String soldToAddr1;
  private String soldToAddr2;
  private String soldToAddr3;
  private String soldToAddr4;
  private String soldToAddr5;
  private String soldToAddr6;
  
  private double invoiceTotal;

  public String getInvoice() {
    return invoice;
  }

  public void setInvoice(String invoice) {
    this.invoice = invoice;
  }

  public Date getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(Date invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

//  public double getCashDiscPct() {
//    return cashDiscPct;
//  }
//
//  public void setCashDiscPct(double cashDiscPct) {
//    this.cashDiscPct = cashDiscPct;
//  }
//
//  public Date getDiscTerms() {
//    return discTerms;
//  }
//
//  public void setDiscTerms(Date discTerms) {
//    this.discTerms = discTerms;
//  }
//
//  public Date getNetTerms() {
//    return netTerms;
//  }
//
//  public void setNetTerms(Date netTerms) {
//    this.netTerms = netTerms;
//  }


  public String getTermsCode() {
    return termsCode;
  }

  public void setTermsCode(String termsCode) {
    this.termsCode = termsCode;
  }

  public String getTermsDesc() {
    return termsDesc;
  }

  public void setTermsDesc(String termsDesc) {
    this.termsDesc = termsDesc;
  }

  public String getPurchaseOrder() {
    return purchaseOrder;
  }

  public void setPurchaseOrder(String purchaseOrder) {
    this.purchaseOrder = purchaseOrder;
  }

  public String getSalesOrder() {
    return salesOrder;
  }

  public void setSalesOrder(String salesOrder) {
    this.salesOrder = salesOrder;
  }

  public String getBillOfLading() {
    return billOfLading;
  }

  public void setBillOfLading(String billOfLading) {
    this.billOfLading = billOfLading;
  }

  public String getHowShip() {
    return howShip;
  }

  public void setHowShip(String howShip) {
    this.howShip = howShip;
  }

  public String getFob() {
    return fob;
  }

  public void setFob(String fob) {
    this.fob = fob;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public String getApprovalNeeded() {
    return approvalNeeded;
  }

  public void setApprovalNeeded(String approvalNeeded) {
    this.approvalNeeded = approvalNeeded;
  }

  public String getApprovalCode() {
    return approvalCode;
  }

  public void setApprovalCode(String approvalCode) {
    this.approvalCode = approvalCode;
  }

  public String getCustomerCode() {
    return customerCode;
  }

  public void setCustomerCode(String customerCode) {
    this.customerCode = customerCode;
  }

  public String getShipToAddr1() {
    return shipToAddr1;
  }

  public void setShipToAddr1(String shipToAddr1) {
    this.shipToAddr1 = shipToAddr1;
  }

  public String getShipToAddr2() {
    return shipToAddr2;
  }

  public void setShipToAddr2(String shipToAddr2) {
    this.shipToAddr2 = shipToAddr2;
  }

  public String getShipToAddr3() {
    return shipToAddr3;
  }

  public void setShipToAddr3(String shipToAddr3) {
    this.shipToAddr3 = shipToAddr3;
  }

  public String getShipToAddr4() {
    return shipToAddr4;
  }

  public void setShipToAddr4(String shipToAddr4) {
    this.shipToAddr4 = shipToAddr4;
  }

  public String getShipToAddr5() {
    return shipToAddr5;
  }

  public void setShipToAddr5(String shipToAddr5) {
    this.shipToAddr5 = shipToAddr5;
  }

  public String getShipToAddr6() {
    return shipToAddr6;
  }

  public void setShipToAddr6(String shipToAddr6) {
    this.shipToAddr6 = shipToAddr6;
  }

  public String getSoldToAddr1() {
    return soldToAddr1;
  }

  public void setSoldToAddr1(String soldToAddr1) {
    this.soldToAddr1 = soldToAddr1;
  }

  public String getSoldToAddr2() {
    return soldToAddr2;
  }

  public void setSoldToAddr2(String soldToAddr2) {
    this.soldToAddr2 = soldToAddr2;
  }

  public String getSoldToAddr3() {
    return soldToAddr3;
  }

  public void setSoldToAddr3(String soldToAddr3) {
    this.soldToAddr3 = soldToAddr3;
  }

  public String getSoldToAddr4() {
    return soldToAddr4;
  }

  public void setSoldToAddr4(String soldToAddr4) {
    this.soldToAddr4 = soldToAddr4;
  }

  public String getSoldToAddr5() {
    return soldToAddr5;
  }

  public void setSoldToAddr5(String soldToAddr5) {
    this.soldToAddr5 = soldToAddr5;
  }

  public String getSoldToAddr6() {
    return soldToAddr6;
  }

  public void setSoldToAddr6(String soldToAddr6) {
    this.soldToAddr6 = soldToAddr6;
  }

  public double getInvoiceTotal() {
    return invoiceTotal;
  }

  public void setInvoiceTotal(double invoiceTotal) {
    this.invoiceTotal = invoiceTotal;
  }

  public String getLoadNumber() {
    return loadNumber;
  }

  public void setLoadNumber(String loadNumber) {
    this.loadNumber = loadNumber;
  }

  @Override
  public String toString() {
    return "Header{" +
            "invoice='" + invoice + '\'' +
            ", invoiceDate=" + invoiceDate +
            ", termsCode='" + termsCode + '\'' +
            ", termsDesc='" + termsDesc + '\'' +
            ", purchaseOrder='" + purchaseOrder + '\'' +
            ", salesOrder='" + salesOrder + '\'' +
            ", billOfLading='" + billOfLading + '\'' +
            ", howShip='" + howShip + '\'' +
            ", fob='" + fob + '\'' +
            ", jobName='" + jobName + '\'' +
            ", approvalNeeded='" + approvalNeeded + '\'' +
            ", approvalCode='" + approvalCode + '\'' +
            ", customerCode='" + customerCode + '\'' +
            ", loadNumber='" + loadNumber + '\'' +
            ", shipToAddr1='" + shipToAddr1 + '\'' +
            ", shipToAddr2='" + shipToAddr2 + '\'' +
            ", shipToAddr3='" + shipToAddr3 + '\'' +
            ", shipToAddr4='" + shipToAddr4 + '\'' +
            ", shipToAddr5='" + shipToAddr5 + '\'' +
            ", shipToAddr6='" + shipToAddr6 + '\'' +
            ", soldToAddr1='" + soldToAddr1 + '\'' +
            ", soldToAddr2='" + soldToAddr2 + '\'' +
            ", soldToAddr3='" + soldToAddr3 + '\'' +
            ", soldToAddr4='" + soldToAddr4 + '\'' +
            ", soldToAddr5='" + soldToAddr5 + '\'' +
            ", soldToAddr6='" + soldToAddr6 + '\'' +
            ", invoiceTotal=" + invoiceTotal +
            '}';
  }
}

