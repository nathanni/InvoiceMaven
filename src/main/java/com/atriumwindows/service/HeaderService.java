package com.atriumwindows.service;

import com.atriumwindows.dao.HeaderDAO;
import com.atriumwindows.dao.impl.HeaderDAOImpl;
import com.atriumwindows.domain.Header;

/**
 * Created by nni on 12/15/2015.
 */
public class HeaderService {

    HeaderDAO headerDAO = new HeaderDAOImpl();

    public Header getHeader(String invoice) {
        Header header = headerDAO.getHeaderByInovice(invoice);
        headerDAO.setOrdermasterInfo(header);
        return header;
    }



}
