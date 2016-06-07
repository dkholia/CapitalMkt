package com.dcsoft.capmkt.orm.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dcsoft.capmkt.orm.ChChannelCustomer;

public class ChannelCustomerDAO extends GenericDAOImpl  {

	public Serializable getCustomerDetails(BigDecimal id) {
		ChChannelCustomer customer = (ChChannelCustomer) getById(ChChannelCustomer.class, id.intValue());
		getHibernateTemplate().initialize(customer.getChGroups());
		return customer;
	}

}
