package com.itheima.crm.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.domain.LinkMan;
import com.itheima.crm.domain.PageBean;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 联系人的action
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	//模型驱动使用对象
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	
	//注入联系人的service
	private LinkManService linkManService;
	
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	//分页参数
	private Integer currPage=1;
	private Integer pageSize=3;
	public void setCurrPage(Integer currPage) {
		if (currPage == null) {
			currPage = 1;
		}
		this.currPage = currPage;
	}
	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}
	
	//注入客户的service
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//查询联系人列表的Action
	public String findAll() {
		//创建离线条件查询：
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		//设置条件
		if (linkMan.getLkm_name() != null) {
			
			detachedCriteria.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		if (linkMan.getLkm_gender() != null && !"".equals(linkMan.getLkm_gender())) {
			detachedCriteria.add(Restrictions.eq("lkm_gender", linkMan.getLkm_gender()));
		}
		//调用业务层
		PageBean<LinkMan> pageBean = linkManService.findAll(detachedCriteria,currPage,pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/*
	 * 跳转到添加页面
	 */
	public String saveUI() {
		//查询所有客户
		List<Customer> list = customerService.findAll();
		//将list集合保存到值栈中,下面的set方法用来保存集合，如果是一个对象则push可以了
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	/*
	 * 保存联系人
	 */
	public String save() {
		//调用业务层
		linkManService.save(linkMan);
		return "saveSuccess";
	}
	
	/*
	 * 修改联系人
	 */
	public String edit() {
		//查询所有客户
		List<Customer> list = customerService.findAll();
		//根据id查询联系人
		linkMan = linkManService.findById(linkMan.getLkm_id());
		//将list和linkMan带到页面上
		ActionContext.getContext().getValueStack().set("list", list);
		//将对象值存入到值栈中
		ActionContext.getContext().getValueStack().push(linkMan);
		
		return "editSuccess";
		
	}
	
	/*
	 * 更新联系人
	 */
	public String update() {
		//调用业务层
		linkManService.update(linkMan);
		
		return "updateSuccess";
	}
	
	/*
	 * 删除联系人
	 */
	public String delete() {
		//根据id查询联系人
		linkMan = linkManService.findById(linkMan.getLkm_id());
		//删除联系人
		linkManService.delete(linkMan);
		return "deleteSuccess";
	}
}

