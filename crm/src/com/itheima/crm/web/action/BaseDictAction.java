package com.itheima.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itheima.crm.domain.BaseDict;
import com.itheima.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {

	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}

	//注入service
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
	/*
	 * 根据类型名称查询字典的方法：findByTypeCode
	 */
	public String findByTypeCode() throws Exception {
		System.out.println("findByTypeCode方法执行了。。");
		//调用业务层查询
		List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
		//将list转成JSON。----jsonlib  fastjson
		
		/*
		 * JSONConfig:json转json的配置对象，比如有8个对象，只需要2个，就用到这个对象
		 * JSONArray:将数组和list集合转成JSON
		 * JSONOject：将对象和map集合转成JSON
		 */
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {"dict_sort","dict_enable","dict_memo"});
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
		System.out.println(jsonArray.toString());
		//将json打印到页面：
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
	
	
}
