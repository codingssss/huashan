package com.itheima.crm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.BaseDao;
/*
 * 通用dao接口的实现类
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;

	/*//方案一：定义一个有参构造方法，将get所需的clazz由子类传入
	public BaseDaoImpl(Class clazz) {
		this.clazz = clazz;
	}*/
	
	//方案二：不想子类上有构造方法，必须在父类中提供无参的构造方法，在无参构造的方法中获得具体类型的Class，具体类型的Class是参数类型中的实际参数类型
	public BaseDaoImpl() {
		//反射：第一步获得Class
		Class clazz = this.getClass();//正在被调用的那个类的Class，即CustomerDaoImpl或LinkManDaoImpl
		//查看JDK的API
		Type type = clazz.getGenericSuperclass();//参数化类型：BaseDaoImpl<Customer>或BaseDaoImpl<LinkMan>
		System.out.println(type);
		//得到这个type就是一个参数化的类型，将type强转成参数化类型
		ParameterizedType pType = (ParameterizedType) type;
		//通过参数类型获得实际类型参数：得到一个实际类型参数的数组？Map<String,Integer>
		Type[] types = pType.getActualTypeArguments();
		//只获得第一个实际类型参数即可
		this.clazz = (Class) types[0];//得到Customer、LinkMan、User这样就可以省去在子类存在构造方法
	}
	
	
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T findById(Serializable id) {
		
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
	}

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if (list.size()>0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@Override
	public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

}
