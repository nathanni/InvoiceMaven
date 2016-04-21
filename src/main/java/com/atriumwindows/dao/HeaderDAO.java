package com.atriumwindows.dao;

import com.atriumwindows.domain.Header;

public interface HeaderDAO {
  
  Header getHeaderByInovice(String invoice);

  Boolean setOrdermasterInfo(Header header);

  Boolean getTermsDesc(Header header);

  String getInvoiceDate(String invoice);

}
