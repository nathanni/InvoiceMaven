/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.atriumwindows.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.naming.InitialContext;

/**
 *
 * @author nni
 */
public class DBConnection {

    //private static DataSource datasource = null;
    private static ComboPooledDataSource datasource = null;
    static {
/*        try {
            InitialContext itx = new InitialContext();
            datasource = (DataSource) itx.lookup("atrium-service");
        } catch (Exception e) {
            System.out.println("Error has Occured on Initializing Datasource: " + e.getMessage());
        }    */
        try {
            datasource = new ComboPooledDataSource("");
            datasource.setDriverClass("oracle.jdbc.OracleDriver"); //loads the jdbc driver
            datasource.setJdbcUrl("jdbc:oracle:thin:@192.168.100.42:1521:wwdev");
            datasource.setUser("mssql");
            datasource.setPassword("mssql");
        } catch(Exception e) {

    }
    }



    public static Connection getConnection() throws SQLException{
        return datasource.getConnection();
    }

    public static void releaseConnection(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void releaseConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
        releaseConnection(connection);
    }



}
