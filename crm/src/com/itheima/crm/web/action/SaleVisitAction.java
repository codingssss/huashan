package com.itheima.crm.web.action;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.itheima.crm.domain.PageBean;
import com.itheima.crm.domain.SaleVisit;
import com.itheima.crm.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

	//模型驱动创建对象
	private SaleVisit saleVisit  = new SaleVisit();
	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}
	
	//注入service
	@Resource(name="saleVisitService")
	private SaleVisitService saleVisitService;
	
	private Integer currPage = 1;
	private Integer pageSize = 3;
	
	public void setCurrPage(Integer currPage) {
		if (currPage == 0) {
			currPage = 1;
		}
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize == 0) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}

	public Date visit_end_time;
	
	public void setVisit_end_time(Date visit_end_time) {
		this.visit_end_time = visit_end_time;
	}

	//要将visit_end_time数据传到值栈中，不必要用压入栈的方式，直接get方法即可
	public Date getVisit_end_time() {
		return visit_end_time;
	}	
	public String findAll() {
		//离线条件查询
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
		//设置条件
		if (saleVisit.getVisit_time() != null) {
			detachedCriteria.add(Restrictions.ge("visit_time", saleVisit.getVisit_time()));
		}
		if (visit_end_time != null) {
			detachedCriteria.add(Restrictions.le("visit_time", visit_end_time));
		}
		//调用业务层
		PageBean<SaleVisit> pageBean = saleVisitService.findByPage(detachedCriteria,currPage,pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll";
	}
	
	

	public String saveUI() {
		
		return "saveUI";
	}
	
	//保存拜访记录
	public String save() {
		//调用该业务层
		saleVisitService.save(saleVisit);
		
		return "saveSuccess";
	}

}
