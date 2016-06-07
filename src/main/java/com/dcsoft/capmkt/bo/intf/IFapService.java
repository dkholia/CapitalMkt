package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface IFapService extends IGenericService {
	public List<Serializable> getFapByCriteria(Serializable fapTO);
	public boolean addServiceAccess(Serializable fapTO);
	public void removeFap(BigDecimal id);
	public void attachServicesToFAP(BigDecimal fapID, List<BigDecimal> serviceIDs);
	public List<Serializable> getFapByName(String fapName);
	public Serializable getServiceAccessDetails(BigDecimal id);
}
