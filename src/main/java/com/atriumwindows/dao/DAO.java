/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.atriumwindows.dao;

import java.util.List;

/**
 *
 * @author nni
 */
public interface DAO<T> {
    void batch(String sql, Object[]... args);
    
    T get(String sql, Object... args);

    List<T> getForList(String sql, Object... args);
    
    <E> E getForValue(String sql, Object... args);

    List getForValueList(String sql, Object... args);
    
    void update(String sql, Object... args);

}
