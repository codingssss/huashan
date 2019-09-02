package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.domain.BaseDict;

/*
 * 字典的接口
 */
public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
