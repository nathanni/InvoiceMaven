/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atriumwindows.dao.impl;

import com.atriumwindows.dao.DAO;
import com.atriumwindows.utils.DBConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nni
 */
public class DAOImpl<T> implements DAO<T> {

    private QueryRunner queryRunner;
    private Class<T> type;

    public DAOImpl() {
        queryRunner = new QueryRunner();

        //use reflection to get CLASS
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) superClass;
            Type[] typeArgs = parameterizedType.getActualTypeArguments();
            if (typeArgs != null && typeArgs.length > 0) {
                if (typeArgs[0] instanceof Class) {
                    type = (Class<T>) typeArgs[0];
                }
            }
        }
    }

    @Override
    public void batch(String sql, Object[]  
        ... args) {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            queryRunner.batch(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.releaseConnection(connection);
        }
    }

    @Override
    public T get(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public List<T> getForList(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public <E> E getForValue(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            return (E) queryRunner.query(connection, sql, new ScalarHandler<E>(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public List getForValueList(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            return queryRunner.query(connection, sql, new ColumnListHandler<String>(1), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public void update(String sql, Object... args) {
        Connection connection = null;
        try {
            connection = DBConnection.getConnection();
            queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.releaseConnection(connection);
        }
    }


}
