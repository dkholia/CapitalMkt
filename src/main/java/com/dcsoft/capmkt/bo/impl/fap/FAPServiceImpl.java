package com.dcsoft.capmkt.bo.impl.fap;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.GenericService;
import com.dcsoft.capmkt.bo.impl.ObjectHashImpl;
import com.dcsoft.capmkt.bo.intf.IFapService;
import com.dcsoft.capmkt.bo.transferobj.ChFapTO;
import com.dcsoft.capmkt.orm.ChFap;
import com.dcsoft.capmkt.orm.ChFapServiceMapping;
import com.dcsoft.capmkt.orm.ChFapServiceMappingId;
import com.dcsoft.capmkt.orm.dao.impl.ServiceAccessDAO;

@Service
public class FAPServiceImpl extends ObjectHashImpl implements IFapService {

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

	@Override
	@Transactional
	public boolean addServiceAccess(Serializable fapTO) {
		try {
			ChFapTO tfrObj = (ChFapTO) fapTO;
			ChFap fap = new ChFap();
			fap.setFapName(tfrObj.getFapName());
			fap.setFapDescription(tfrObj.getFapDescription());
			fap.setChannel((short) 1);
			getGenericDao().add(fap);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public void removeFap(BigDecimal id) {
		getFapDAO().remove(ChFap.class, id.intValue());
	}

	@Override
	@Transactional
	public void attachServicesToFAP(BigDecimal fapID, List<BigDecimal> serviceIDs) {
		ChFapServiceMapping mapping = null;
		ChFapServiceMappingId id ;
		if(serviceIDs!=null && serviceIDs.size()>0){
			for(BigDecimal serviceID : serviceIDs){
				id = new ChFapServiceMappingId(serviceID, fapID);
				mapping = new ChFapServiceMapping(id);
				getGenericDao().add(mapping);
			}
		}
		
	}

	@Override
	@Transactional
	public List<Serializable> getFapByName(String fapName) {
		ChFap fap = new ChFap((short) 1);
		fap.setFapName(fapName.trim());
		return fapDAO.getFapByCriteria(fap);
	}

	@Override
	@Transactional
	public Serializable getServiceAccessDetails(BigDecimal id) {
		return fapDAO.getServiceAccessDetails(id);
	}
}
