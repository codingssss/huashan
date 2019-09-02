package com.itheima.crm.service;


import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.PageBean;
import com.itheima.crm.domain.SaleVisit;

public interface SaleVisitService {

	PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(SaleVisit saleVisit);

}
