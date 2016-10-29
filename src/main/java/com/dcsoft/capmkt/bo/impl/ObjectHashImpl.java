package com.dcsoft.capmkt.bo.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.intf.IObjectHash;
import com.dcsoft.capmkt.bo.transferobj.Model;
@Service
public class ObjectHashImpl extends GenericService implements IObjectHash {

	@Override
	@Transactional
	public void saveObjectHash(Class<? extends Model> clazz, String idColumnName, BigDecimal objectID, BigDecimal objectHash) {
		getGenericDao().saveObjectHash(clazz,idColumnName, objectID, objectHash);
	}

	@Override
	public List<Serializable> list() {
		return null;
	}

	@Override
	public List<Serializable> findByExample(Class<?> clazz, Serializable obj) {
		return null;
	}

}
