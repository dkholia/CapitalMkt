package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.dcsoft.capmkt.bo.transferobj.ChDapTO;

public interface IDapService extends IObjectHash {
	public List<Serializable> getChannelCustomersDropDown();
	public boolean addDataAccess(ChDapTO chDapTO) throws Exception;
	public List<Serializable> getDataAccessByName(String dapName);
	public List<Serializable> getDapByCriteria(Serializable fapTO);
	public Serializable getDataAccessDetails(BigDecimal id);
}
