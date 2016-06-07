package com.dcsoft.capmkt.orm.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.dcsoft.capmkt.orm.ChObjectMapping;
import com.dcsoft.capmkt.orm.ChObjectMappingId;
import com.dcsoft.capmkt.orm.dao.intf.IGenericDao;

public class GenericDAOImpl extends HibernateDaoSupport  implements IGenericDao {

	private static final Logger logger = LoggerFactory.getLogger(GenericDAOImpl.class);
	 
    @Autowired
	private SessionFactory sessionFactory;
    
	@Override
	public void add(Serializable entity) {
		 getHibernateTemplate().persist(entity);
	     logger.info("Object saved successfully, Object Details="+entity.toString());
	}

	@Override
	public void update(Serializable entity) {
		// Session session = getSession();
		 getHibernateTemplate().update(entity);
	     logger.info("Object saved successfully, Object Details="+entity.toString());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Serializable> list(String name) {
			List<Serializable> objList = getSession().createQuery("from " + name ).list();
	        for(Serializable obj : objList){
	            logger.info("Object List::"+obj);
	        }
	        return objList;
	}

	@Override
	public Serializable getById(Class clazz, int id) {
	     Serializable returnObj = (Serializable) getSession().load(clazz, new BigDecimal(id));
	     logger.info( clazz.getName() + " loaded successfully, "+ clazz.getName()+ " details="+returnObj);
	     return returnObj;
	}

	@Override
	public void remove(Class clazz, int id) {
		 Session session = getSession();
		  Serializable returnObj = (Serializable) session.load(clazz, new BigDecimal(id));
	        if(null != returnObj){
	            session.delete(returnObj);
	        }
	        logger.info( clazz.getName() + " deleted successfully ");
	}

	@Override
	public List<Serializable> getByProperty(Class clazz, String properyName) {
		return null;
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Serializable> findByExample(Class clazz, Serializable obj) {
		return getSession().createCriteria(clazz)
				 .add( Example.create(obj) )
				 .list();
	}


	@Override
	public List<Serializable> executeSqlQuery(String sql, Map<String, Object> params,Class entity) {
		Session session = getSession();
		SQLQuery query = null;
		if(null==params){
			query = session.createSQLQuery(sql);
			query.addEntity(entity);
			return query.list();
			
		}else{
		}
		return null;
	}
	
	public Session getSession() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}
	
	public void saveObjectHash(String name, String objectID, String objectHash) {
		ChObjectMappingId id = new ChObjectMappingId(name, objectID, objectHash);
		ChObjectMapping mapping = new ChObjectMapping(id);
		add(mapping);
	}

}
