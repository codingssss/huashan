package com.itheima.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.UserDao;
import com.itheima.crm.domain.User;
/*
 * 用户管理DAO的实现类
 * 整合hibernate，交给spring管理
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	/*public UserDaoImpl() {
		super(User.class);
	}*/
	
	/*@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
		
	}*/

	@Override
	//dao中根据用户名和密码进行查询的方法
	public User login(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?", user.getUser_code(),user.getUser_password());
		//判断一下：
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	
	
}
