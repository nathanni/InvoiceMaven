package com.atriumwindows.dao.impl;

import com.atriumwindows.dao.HeaderDAO;
import com.atriumwindows.domain.Header;

public class HeaderDAOImpl extends DAOImpl<Header> implements HeaderDAO {

    @Override
    public Header getHeaderByInovice(String invoice) {

//        String sql = "SELECT  d.invoice, d.invoice_date invoiceDate, d.cash_disc_pct cashDiscPct, "
//                + "to_date(d.disc_terms,'yyyymmdd') discTerms, to_date(d.net_terms,'yyyymmdd') netTerms, "
        String sql = "SELECT  d.invoice, d.invoice_date invoiceDate, TRIM(d.terms_of_sale) termsCode, "
                + "TRIM(d.purchaseorder) purchaseOrder, TRIM(d.salesorder) salesOrder, "
                + "TRIM(d.bol) billOfLading, TRIM(d.how_ship) howShip, TRIM(d.fob) fob, TRIM(d.custcode) customerCode, "
                + "TRIM(d.shipto_nm_addr1) shipToAddr1, TRIM(d.shipto_nm_addr2) shipToAddr2, TRIM(d.shipto_nm_addr3) shipToAddr3, "
                + "TRIM(d.shipto_nm_addr4) shipToAddr4, TRIM(d.shipto_nm_addr5) shipToAddr5, TRIM(d.shipto_nm_addr6) shipToAddr6, "
                + "TRIM(d.soldto_nm_addr1) soldToAddr1, TRIM(d.soldto_nm_addr2) soldToAddr2, TRIM(d.soldto_nm_addr3) soldToAddr3, "
                + "TRIM(d.soldto_nm_addr4) soldToAddr4, TRIM(d.soldto_nm_addr5) soldToAddr5, TRIM(d.soldto_nm_addr6) soldToAddr6, "
                + "d.gross_invoice invoiceTotal, d.sales_tax_amt salesTax, d.net_invoice_amt netInvoice "
                + "FROM dts_arimaster d WHERE invoice = ? AND rownum = 1 ";

        return this.get(sql, invoice);
    }

    @Override
    public Boolean setOrdermasterInfo(Header header) {

        if (header == null) {
            return false;
        }

        String salesOrder = header.getSalesOrder();

        if(salesOrder == null || salesOrder.isEmpty()) {
            return false;
        }

//        System.out.println(header.getInvoiceDate().getTime());
//        System.out.println(header.getNetTerms().getTime());
//        System.out.println(header.getDiscTerms().getTime());
//
//        long diff = Math.abs(header.getDiscTerms().getTime() - header.getInvoiceDate().getTime());
//        long diffDays = diff / (24 * 60 * 60 * 1000);
//        System.out.println(diffDays);
//
//        long diff2 = Math.abs(header.getNetTerms().getTime() - header.getInvoiceDate().getTime());
//        long diffDays2 = diff2 / (24 * 60 * 60 * 1000);
//        System.out.println(diffDays2);

        String sql = "SELECT namejob jobName FROM ordermaster WHERE salesorder = ?";
        header.setJobName(this.getForValue(sql, salesOrder));

        sql = "SELECT approvalneeded approvalNeeded FROM ordermaster WHERE salesorder = ?";
        Object approvalNeeded = this.getForValue(sql, salesOrder);
        if (approvalNeeded != null)
            header.setApprovalNeeded(approvalNeeded.toString()); //convert BigDecemal to String

        sql = "SELECT approvalcode approvalCode FROM ordermaster WHERE salesorder = ?";
        Object approvalCode = this.getForValue(sql, salesOrder);
        if (approvalCode != null)
            header.setApprovalCode(approvalCode.toString()); //convert BigDecemal to String

        sql = "SELECT bol FROM ordermaster WHERE salesorder = ?";
        header.setLoadNumber(this.getForValue(sql, salesOrder));

        return true;
    }

    //get terms description from payment_terms
    @Override
    public Boolean getTermsDesc(Header header) {
        if (header == null) {
            return false;
        }

        String termsCode = header.getTermsCode();

        if (termsCode == null || termsCode.isEmpty()) {
            return false;
        }

        String sql = "SELECT term_descr FROM payment_terms WHERE term = ?";
        String termsDesc = this.getForValue(sql, termsCode);
        header.setTermsDesc(termsDesc);
        return true;
    }

    @Override
    public String getInvoiceDate(String invoice) {
        String sql = "SELECT to_char(invoice_date,'MM/dd/yyyy') FROM dts_arimaster WHERE invoice = ? AND rownum = 1";
        return this.getForValue(sql, invoice);
    }


}
