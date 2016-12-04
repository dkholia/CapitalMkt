package com.dcsoft.capmkt.orm.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.dcsoft.capmkt.orm.ChChannelCustomer;

public class ChannelCustomerDAO extends GenericDAOImpl  {

	public Serializable getCustomerDetails(BigDecimal id) {
		ChChannelCustomer customer = (ChChannelCustomer) getById(ChChannelCustomer.class, id.intValue());
		getHibernateTemplate().initialize(customer.getChGroups());
		return customer;
	}
	
	@SuppressWarnings("unchecked")
	public List<Serializable> getCustomerByCriteria(ChChannelCustomer customer){
		if(customer.getChannelCustName()==null || customer.getChannelCustName().trim().equals(""))
			return null;
		else
			return getSession().createCriteria(ChChannelCustomer.class)
					.add(Restrictions.ilike("channelCustName", customer.getChannelCustName(), MatchMode.ANYWHERE)).list();
	}

}
