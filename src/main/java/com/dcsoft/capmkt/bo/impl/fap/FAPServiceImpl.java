package com.dcsoft.capmkt.bo.impl.fap;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.GenericService;
import com.dcsoft.capmkt.bo.intf.IFapService;
import com.dcsoft.capmkt.bo.transferobj.ChFapTO;
import com.dcsoft.capmkt.orm.ChFap;
import com.dcsoft.capmkt.orm.dao.impl.ServiceAccessDAO;

@Service
public class FAPServiceImpl extends GenericService implements IFapService {

	private ServiceAccessDAO fapDAO;
	
	public ServiceAccessDAO getFapDAO() {
		return fapDAO;
	}

	public void setFapDAO(ServiceAccessDAO fapDAO) {
		this.fapDAO = fapDAO;
	}

	@Override
	@Transactional
	public List<Serializable> list() {
		return getGenericDao().list("ChFap");
	}

	@Override
	@Transactional
	public List<Serializable> findByExample(Class<?> clazz, Serializable obj) {
		return super.getGenericDao().findByExample(clazz, obj);
	}

	@Override
	@Transactional
	public List<Serializable> getFapByCriteria(Serializable fapTO) {
		ChFapTO chFapTO = (ChFapTO) fapTO;
		ChFap fap = new ChFap((short) 1);
		fap.setFapName(chFapTO.getFapName().trim());
		return fapDAO.getFapByCriteria(fap);
	}
}
