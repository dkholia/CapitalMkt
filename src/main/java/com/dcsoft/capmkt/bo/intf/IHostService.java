package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.dcsoft.capmkt.bo.transferobj.ChHostTO;
import com.dcsoft.capmkt.orm.ChHost;

public interface IHostService {

	public void addHost(ChHostTO p);
	public void updateHost(ChHostTO p);
	public List<Serializable> listHosts();
	public ChHost getHostById(BigDecimal id);
	public void removeHost(BigDecimal id);
	public List<Serializable> findByExample(Serializable obj);
}
