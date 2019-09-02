package com.itheima.crm.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.itheima.crm.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/*
 * 权限拦截器
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断session中是否有登陆用户的信息
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if (existUser == null) {
			//存错误信息，页面跳转到登陆页面
			ActionSupport actionSupport = (ActionSupport) invocation.getAction();
			actionSupport.addActionError("您还没有登陆！没有权限访问");
			return actionSupport.LOGIN;
		}else {
			//已经登陆，放行
			return invocation.invoke();
		}
		
	}

}
