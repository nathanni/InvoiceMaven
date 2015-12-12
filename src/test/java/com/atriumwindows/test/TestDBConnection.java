package com.atriumwindows.test;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.atriumwindows.utils.DBConnection;
import org.junit.Test;

import java.sql.SQLException;

/**
 *
 * @author nni
 */
public class TestDBConnection {
    @Test
    public void test() throws SQLException {
        System.out.println(DBConnection.getConnection());
    }
    
}
