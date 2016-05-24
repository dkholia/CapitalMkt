package com.dcsoft.capmkt.orm.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
	
	@SuppressWarnings("unchecked")
	public List<Serializable> getGroupByCriteria(ChGroup chGroup){
		if(chGroup.getGroupName()==null || chGroup.getGroupName().trim().equals(""))
			return findByExample(ChGroup.class, new ChGroup());
		else
			return getSession().createCriteria(ChGroup.class)
					.add(Restrictions.ilike("groupName", chGroup.getGroupName(), MatchMode.ANYWHERE)).list();
	}
}
