package com.dcsoft.capmkt.orm.dao.impl;

import java.math.BigDecimal;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import com.dcsoft.capmkt.orm.ChUser;

public class UserDAO extends GenericDAOImpl {

	private SessionFactory sessionFactory;
	
	public UserDAO() {
	}
	
	public ChUser getUserDetailsByID(BigDecimal userID) throws Exception{
		ChUser user = (ChUser) getById(ChUser.class, userID.intValue());
		Hibernate.initialize(user);
		return user;
	}
	
	public ChUser getUserDetails(ChUser user) throws Exception{
		Hibernate.initialize(user);
		return user;
	}
}
