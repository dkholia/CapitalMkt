package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.util.List;

public interface IDapService extends IGenericService {
	public List<Serializable> getChannelCustomersDropDown();
}
