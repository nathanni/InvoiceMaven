package com.atriumwindows.dao;

import com.atriumwindows.domain.Header;

public interface HeaderDAO {
  
  Header getHeaderByInovice(String invoice);
  
}
