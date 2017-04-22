package com.xf.college.dao;

import java.util.List;

/**
 * Created by xufeng on 2017/4/9.
 */
public interface BaseDao<T,K> {

    int  add(T t);
    int  update(T t);
    List<T> selectAll();
    T select(K id);
    List<T> selectByName(String name);
    int delete(K id);
}
