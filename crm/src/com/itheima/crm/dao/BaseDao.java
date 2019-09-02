package com.itheima.crm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/*
 * 通用的dao接口
 */
public interface BaseDao<T> {

	void save(T t);
	void update(T t);
	void delete(T t);
	
	public T findById(Serializable id);
	
	//查询所有
	public List<T> findAll();
	
	//查询总记录数
	Integer findCount(DetachedCriteria detachedCriteria);
	
	//分页查询
	List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);
}
