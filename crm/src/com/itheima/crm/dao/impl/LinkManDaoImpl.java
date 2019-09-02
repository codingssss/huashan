package com.itheima.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.LinkManDao;
import com.itheima.crm.domain.LinkMan;
/*
 * 联系人dao的实现类
 */

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {

	/*public LinkManDaoImpl() {
		super(LinkMan.class);
	}*/

	/*@Override
	//dao中统计个数的方法
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if (list.size()>0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@Override
	//dao的分页查询
	public List<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
		return list;
	}

	


	@Override
	public LinkMan findById(Long lkm_id) {
		
		return this.getHibernateTemplate().get(LinkMan.class, lkm_id);
	}*/

	

}
