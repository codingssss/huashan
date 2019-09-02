package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.domain.BaseDict;

/*
 * 字典的dao
 */
public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> findByTypeCode(String dict_type_code);

	
}
