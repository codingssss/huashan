package com.itheima.crm.dao;

import com.itheima.crm.domain.User;

/*
 * 用户管理的DAO接口
 */
public interface UserDao extends BaseDao<User> {

	/*void save(User user);*/

	User login(User user);


}
