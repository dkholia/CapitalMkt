package com.dcsoft.capmkt.bo.impl;

import org.springframework.stereotype.Service;

import com.dcsoft.capmkt.orm.dao.intf.IGenericDao;

@Service
public  abstract class GenericService{

	private IGenericDao genericDao;
	
	public IGenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(IGenericDao genericDao) {
		this.genericDao = genericDao;
	}

}
