package com.dcsoft.capmkt.bo.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.intf.LoginService;
import com.dcsoft.capmkt.orm.ChUser;
import com.dcsoft.capmkt.orm.dao.impl.GenericDAOImpl;
import com.dcsoft.capmkt.orm.dao.impl.UserDAO;

@Service
public class LoginServiceImpl implements LoginService {
	private GenericDAOImpl genericDao;
	private UserDAO userDAO;
	
	public void setGenericDao(GenericDAOImpl genericDao) {
		this.genericDao = genericDao;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	@Transactional
	public List<Serializable> findByExample(Serializable obj) {
		return this.genericDao.findByExample(ChUser.class, obj);
	}
	@Override
	@Transactional
	public ChUser getUserDetailsByID(BigDecimal userID) throws Exception {
		return this.userDAO.getUserDetailsByID(userID);
	}
	@Override
	@Transactional
	public ChUser getUserDetails(ChUser user) throws Exception {
		return this.userDAO.getUserDetails(user);
	}
	

}
