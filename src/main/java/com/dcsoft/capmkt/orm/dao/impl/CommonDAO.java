package com.dcsoft.capmkt.orm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.dcsoft.capmkt.orm.BccCountry;
import com.dcsoft.capmkt.orm.BccStateRef;

public class CommonDAO extends GenericDAOImpl implements Serializable {

	private static final long serialVersionUID = 3665607328689329714L;

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<Serializable> getCountryCodes() {
		return getSession()
				.createCriteria(BccCountry.class)
				.addOrder( Order.asc("countryCodeEn") ).list();
	}
	@SuppressWarnings("unchecked")
	public List<Serializable> getStates(String countryName){
		return getSession()
		.createCriteria(BccStateRef.class)
			.add(Restrictions.eq("id.countryCodeEn", countryName))
				.list();
	}
}
