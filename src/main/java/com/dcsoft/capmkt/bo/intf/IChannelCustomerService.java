package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public interface IChannelCustomerService extends IObjectHash {
	public List<Serializable> getCustomerByExample(Serializable obj);
	public boolean addCustomer(Serializable obj);
	public Serializable getCustomerDetails(BigDecimal id);
}
