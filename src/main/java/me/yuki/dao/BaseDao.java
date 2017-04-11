package me.yuki.dao;

import java.util.List;

/**
 * Created by Ayakura Yuki on 2017/4/10.
 */
public interface BaseDao<T> {

	T get(String id);

	List<T> findList(T entity);

	List<T> findAll();

	int insert(T entity);

	int update(T entity);

	int delete(T entity);

}
