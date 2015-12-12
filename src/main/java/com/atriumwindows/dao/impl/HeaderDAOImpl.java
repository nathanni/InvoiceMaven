package com.atriumwindows.dao.impl;

import com.atriumwindows.dao.HeaderDAO;
import com.atriumwindows.domain.Header;

public class HeaderDAOImpl extends DAOImpl<Header> implements HeaderDAO {

  @Override
  public Header getHeaderByInovice(String invoice) {
    
    String sql = "SELECT  d.invoice, d.invoice_date invoiceDate, d.cash_disc_pct cashDiscPct, "
        + "to_date(d.disc_terms,'yyyymmdd') discTerms, to_date(d.net_terms,'yyyymmdd') netTerms, " 
        + "TRIM(d.purchaseorder) purchaseOrder, TRIM(d.salesorder) salesOrder, "
        + "TRIM(d.bol) billOfLading, TRIM(d.how_ship) howShip, TRIM(d.fob) fob, "
        + "o.namejob jobName, o.approvalneeded approvalNeeded,o.approvalcode approvalCode, TRIM(d.custcode) customerCode, " 
        + "TRIM(d.shipto_nm_addr1) shipToAddr1, TRIM(d.shipto_nm_addr2) shipToAddr2, TRIM(d.shipto_nm_addr3) shipToAddr3, " 
        + "TRIM(d.shipto_nm_addr4) shipToAddr4, TRIM(d.shipto_nm_addr5) shipToAddr5, TRIM(d.shipto_nm_addr6) shipToAddr6, " 
        + "TRIM(d.soldto_nm_addr1) soldToAddr1, TRIM(d.soldto_nm_addr2) soldToAddr2, TRIM(d.soldto_nm_addr3) soldToAddr3, " 
        + "TRIM(d.soldto_nm_addr4) soldToAddr4, TRIM(d.soldto_nm_addr5) soldToAddr5, TRIM(d.soldto_nm_addr6) soldToAddr6, "
        + "gross_invoice invoiceTotal "
        + "FROM dts_arimaster d, ordermaster o WHERE invoice = ? AND rownum = 1 ";
    //AND d.invoice = o.invoicenumber
    
    return this.get(sql, invoice);
  }

}
