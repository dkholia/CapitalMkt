package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.dcsoft.capmkt.bo.transferobj.ChannelCustomerTO;

public interface IChannelCustomerService extends IObjectHash {
	public List<Serializable> getCustomerByExample(Serializable obj);
	public boolean addCustomer(Serializable obj);
	public Serializable getCustomerDetails(BigDecimal id);
	public List<Serializable> getCustomersByCriteria(ChannelCustomerTO customerTO);
}
