package com.dcsoft.capmkt.orm.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.dcsoft.capmkt.orm.ChUser;

public class ChannelUserDAO extends GenericDAOImpl  {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ChannelUserDAO() {
		super();
	}
	
	/** 
	 * All associations related to users are <code>FetchType.LAZY</code> , so when getting user details we need to initialize them
	 * @param id
	 * @return
	 */
	public ChUser getUserDetails(BigDecimal id){
		ChUser user = (ChUser) getById(ChUser.class, id.intValue());
		getHibernateTemplate().initialize(user.getChDapUserMappings());
		getHibernateTemplate().initialize(user.getChFapUserMappings());
		getHibernateTemplate().initialize(user.getChUserGroupMappings());
		return user;
	}
	
	@Override
	public List<Serializable> findByExample(Class clazz, Serializable obj) {
		ChUser user = (ChUser) obj;
		Criteria criteria = getSession().createCriteria(clazz);
		if(null!= user.getUname() && !user.getUname().trim().equals("")){
			criteria.add(Restrictions.ilike("uname", user.getUname(),MatchMode.ANYWHERE));
		}
		if(null!=user.getFirstname() && !user.getFirstname().trim().equals("")){
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.ilike("firstname",user.getFirstname(), MatchMode.ANYWHERE));
			disjunction.add(Restrictions.ilike("middlename",user.getFirstname(),MatchMode.ANYWHERE));
			disjunction.add(Restrictions.ilike("lasname",user.getFirstname(),MatchMode.ANYWHERE));
			criteria.add(disjunction);
		}
		return criteria.list();
	}
}
