package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.util.List;

import com.dcsoft.capmkt.bo.transferobj.ChannelCustomerTO;

public interface IChannelCustomerService extends IGenericService {
	public List<Serializable> getCustomerByExample(Serializable obj);
	public boolean addCustomer(Serializable obj);
}
