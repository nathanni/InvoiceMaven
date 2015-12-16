package com.atriumwindows.dao.impl;

import com.atriumwindows.dao.HeaderDAO;
import com.atriumwindows.domain.Header;

public class HeaderDAOImpl extends DAOImpl<Header> implements HeaderDAO {

    @Override
    public Header getHeaderByInovice(String invoice) {

        String sql = "SELECT  d.invoice, d.invoice_date invoiceDate, d.cash_disc_pct cashDiscPct, "
                + "to_date(d.disc_terms,'yyyymmdd') discTerms, to_date(d.net_terms,'yyyymmdd') netTerms, "
                + "TRIM(d.purchaseorder) purchaseOrder, TRIM(d.salesorder) salesOrder, "
                + "TRIM(d.bol) billOfLading, TRIM(d.how_ship) howShip, TRIM(d.fob) fob, TRIM(d.custcode) customerCode, "
                + "TRIM(d.shipto_nm_addr1) shipToAddr1, TRIM(d.shipto_nm_addr2) shipToAddr2, TRIM(d.shipto_nm_addr3) shipToAddr3, "
                + "TRIM(d.shipto_nm_addr4) shipToAddr4, TRIM(d.shipto_nm_addr5) shipToAddr5, TRIM(d.shipto_nm_addr6) shipToAddr6, "
                + "TRIM(d.soldto_nm_addr1) soldToAddr1, TRIM(d.soldto_nm_addr2) soldToAddr2, TRIM(d.soldto_nm_addr3) soldToAddr3, "
                + "TRIM(d.soldto_nm_addr4) soldToAddr4, TRIM(d.soldto_nm_addr5) soldToAddr5, TRIM(d.soldto_nm_addr6) soldToAddr6, "
                + "d.gross_invoice invoiceTotal "
                + "FROM dts_arimaster d WHERE invoice = ? AND rownum = 1 ";

        return this.get(sql, invoice);
    }

    @Override
    public Boolean setOrdermasterInfo(Header header) {

        if (header == null) return false;

        String invoice = header.getInvoice();

        String sql = "SELECT namejob jobName FROM ordermaster WHERE invoicenumber = ?";
        header.setJobName(this.getForValue(sql, invoice));

        sql = "SELECT approvalneeded approvalNeeded FROM ordermaster WHERE invoicenumber = ?";
        Object approvalNeeded = this.getForValue(sql, invoice);
        if (approvalNeeded != null)
            header.setApprovalNeeded(approvalNeeded.toString()); //convert BigDecemal to String

        sql = "SELECT approvalcode approvalCode FROM ordermaster WHERE invoicenumber = ?";
        Object approvalCode = this.getForValue(sql, invoice);
        if (approvalCode != null)
            header.setApprovalCode(approvalCode.toString()); //convert BigDecemal to String

        return true;
    }


}
