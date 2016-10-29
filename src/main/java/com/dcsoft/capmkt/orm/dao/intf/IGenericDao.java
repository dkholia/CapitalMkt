package com.dcsoft.capmkt.orm.dao.intf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IGenericDao {
	 public void add(Serializable obj);
	 public void update(Serializable obj);
	 public List<Serializable> list(String name);
	 public Serializable getById(Class clazz , int id);
	 public void remove(Class clazz, int id);
	 public List<Serializable> getByProperty(Class clazz, String properyName);
	 public List<Serializable> findByExample(Class clazz,Serializable obj);
	 public List<Serializable> executeSqlQuery(String sql,Map<String,Object> params,Class entity);
	 public void saveObjectHash(Serializable clazz, String idColumnName,  BigDecimal objectID, BigDecimal objectHash);
}
