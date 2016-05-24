package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.util.List;

public interface IFapService extends IGenericService {
	public List<Serializable> getFapByCriteria(Serializable fapTO);
}
