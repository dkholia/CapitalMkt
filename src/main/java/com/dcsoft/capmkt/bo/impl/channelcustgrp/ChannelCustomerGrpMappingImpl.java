package com.dcsoft.capmkt.bo.impl.channelcustgrp;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.GenericService;
import com.dcsoft.capmkt.bo.intf.IChannelCustomerGrpMapping;
import com.dcsoft.capmkt.orm.dao.impl.ChChannelCustGrpMappingDAO;

@Service
public class ChannelCustomerGrpMappingImpl extends GenericService implements IChannelCustomerGrpMapping {
	
	private ChChannelCustGrpMappingDAO chChannelCutGrpMappingDao;


	@Override
	@Transactional
	public List<Serializable> list() {
		return chChannelCutGrpMappingDao.list("ChChannelCustGrpMapping");
	}

	@Override
	@Transactional
	public List<Serializable> findByExample(Class<?> clazz, Serializable obj) {
		return null;
	}

	public ChChannelCustGrpMappingDAO getChChannelCutGrpMappingDao() {
		return chChannelCutGrpMappingDao;
	}

	public void setChChannelCutGrpMappingDao(ChChannelCustGrpMappingDAO chChannelCutGrpMappingDao) {
		this.chChannelCutGrpMappingDao = chChannelCutGrpMappingDao;
	}

	
}
