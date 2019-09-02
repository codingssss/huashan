package com.itheima.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.Customer;

/*
 * 客户管理的dao接口
 */
public interface CustomerDao extends BaseDao<Customer> {


	/*Integer findCount(DetachedCriteria detachedCriteria);

	List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

	Customer findById(Long cust_id);


	List<Customer> findAll();*/
	
}
