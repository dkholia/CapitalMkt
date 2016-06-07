package com.dcsoft.capmkt.bo.impl;

import org.springframework.stereotype.Service;

import com.dcsoft.capmkt.orm.dao.impl.ObjectMappingDAO;
import com.dcsoft.capmkt.orm.dao.intf.IGenericDao;

@Service
public  abstract class GenericService{

	private IGenericDao genericDao;
	private ObjectMappingDAO objectDAO;
	
	public IGenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(IGenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	/*@Transactional
	public void saveObjectHash(Class clazz, String objectID, String objectHash){
		objectDAO.saveObjectHash(clazz.getName(),objectID,objectHash);
	}*/
}
