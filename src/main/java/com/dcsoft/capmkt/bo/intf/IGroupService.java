package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.dcsoft.capmkt.bo.transferobj.ChGroupTO;
import com.dcsoft.capmkt.orm.ChGroup;

public interface IGroupService extends IGenericService {
	public void addGroup(ChGroupTO p);
	public void updateGroup(ChGroupTO p);
	public List<Serializable> listGroups();
	public ChGroup getGroupById(BigDecimal id);
	public void removeGroup(BigDecimal id);
	public ChGroup getGroupDetails(BigDecimal id);
}
