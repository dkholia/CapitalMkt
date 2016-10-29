package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.util.List;

public interface ICommonService  extends IObjectHash {
	public List<Serializable> getCountryCodes();
	public List<Serializable> getStates(String countryName);
	public List<Serializable> getServices();
}
