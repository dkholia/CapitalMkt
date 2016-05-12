package com.dcsoft.capmkt.orm.dao.impl;

import java.math.BigDecimal;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dcsoft.capmkt.orm.ChGroup;

public class GroupDAO extends GenericDAOImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public GroupDAO() {
		super();
	}
	
	public ChGroup getGroupDetails(BigDecimal id){
		ChGroup group = (ChGroup) getById(ChGroup.class, id.intValue());
		getHibernateTemplate().initialize(group.getChChannelCustGrpMappings());
		getHibernateTemplate().initialize(group.getChUserGroupMappings());
		return group;
	}
}
