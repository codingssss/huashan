package com.itheima.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.domain.Customer;
/*
 * 客户管理dao接口的实现类
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {


	/*public CustomerDaoImpl() {
		super(Customer.class);
	}*/

	/*@Override
	//dao中带条件统计个数的方法
	public Integer findCount(DetachedCriteria detachedCriteria) {
		//select count(*) from xxx where 条件
		//detachedCriteria相当一个条件对象
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if (list.size()>0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@Override
	//dao中分页查询客户的方法
	public List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);	//findCount查完后的detachedCriteria传到这里，所以需要将条件对象清空，才默认查询所有
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

	@Override
	//dao中根据客户的id查询客户的方法
	public Customer findById(Long cust_id) {
		
		return this.getHibernateTemplate().get(Customer.class, cust_id);
	}


	@Override
	public List<Customer> findAll() {
		
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}*/

	
}
