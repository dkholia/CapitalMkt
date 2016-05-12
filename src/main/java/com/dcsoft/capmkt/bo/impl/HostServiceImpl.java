package com.dcsoft.capmkt.bo.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.intf.IHostService;
import com.dcsoft.capmkt.bo.transferobj.ChHostTO;
import com.dcsoft.capmkt.orm.ChHost;

@Service
public class HostServiceImpl extends GenericService implements IHostService {
	

	@Override
	@Transactional
	public void addHost(ChHostTO p) {
		
		ChHost presistObj = new ChHost();
		presistObj.setHostName(p.getHostName());
		presistObj.setHostDescription(p.getHostDescription());
		getGenericDao().add(presistObj);
	}

	@Override
	@Transactional
	public void updateHost(ChHostTO p) {
		ChHost presistObj = new ChHost();
		presistObj.setHostId(p.getHostId());
		presistObj.setHostName(p.getHostName());
		presistObj.setHostDescription(p.getHostDescription());
		getGenericDao().update(presistObj);
	}

	@Override
	@Transactional
	public List<Serializable> listHosts() {
		return getGenericDao().list("ChHost");
	}

	@Override
	@Transactional
	public ChHost getHostById(BigDecimal id) {
		return (ChHost) getGenericDao().getById(ChHost.class,id.intValue());
	}

	@Override
	@Transactional
	public void removeHost(BigDecimal id) {
		getGenericDao().remove(ChHost.class,id.intValue());
	}

	@Override
	public List<Serializable> findByExample(Serializable obj) {
		return getGenericDao().findByExample(ChHost.class, obj);
	}

}
