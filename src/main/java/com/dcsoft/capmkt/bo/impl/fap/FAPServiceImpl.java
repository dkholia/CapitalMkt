package com.dcsoft.capmkt.bo.impl.fap;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.GenericService;
import com.dcsoft.capmkt.bo.intf.IFapService;

@Service
public class FAPServiceImpl extends GenericService implements IFapService {


	@Override
	@Transactional
	public List<Serializable> list() {
		return getGenericDao().list("ChFap");
	}

	@Override
	@Transactional
	public List<Serializable> findByExample(Class<?> clazz, Serializable obj) {
		return null;
	}

}
