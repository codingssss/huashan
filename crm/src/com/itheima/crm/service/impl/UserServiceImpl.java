package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.UserDao;
import com.itheima.crm.domain.User;
import com.itheima.crm.service.UserService;
import com.itheima.crm.utils.MD5Utils;
/*
 * 用户管理Service的实现类
 */
@Transactional
public class UserServiceImpl implements UserService {

	//注入dao
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	//业务层注册用户的方法
	public void regist(User user) {
		//对密码进行加密的处理
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		//调用dao
		userDao.save(user);
		
	}

	@Override
	//业务层用户登陆的方法
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		//调用dao
		return userDao.login(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}
