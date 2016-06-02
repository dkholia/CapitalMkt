package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.util.List;

import com.dcsoft.capmkt.bo.transferobj.ChDapTO;

public interface IDapService extends IGenericService {
	public List<Serializable> getChannelCustomersDropDown();
	public boolean addDataAccess(ChDapTO chDapTO);
	public List<Serializable> getDataAccessByName(String dapName);
	public List<Serializable> getDapByCriteria(Serializable fapTO);
}
