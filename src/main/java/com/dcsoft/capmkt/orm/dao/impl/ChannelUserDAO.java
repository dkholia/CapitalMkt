package com.dcsoft.capmkt.orm.dao.impl;

import java.math.BigDecimal;

import org.hibernate.SessionFactory;
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
}
