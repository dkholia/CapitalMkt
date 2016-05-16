package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.util.List;

public interface ICommonService  extends IGenericService {
	public List<Serializable> getCountryCodes();
	public List<Serializable> getStates(String countryName);
}
