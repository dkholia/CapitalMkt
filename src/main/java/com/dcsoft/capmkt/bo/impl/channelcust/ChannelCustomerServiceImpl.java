package com.dcsoft.capmkt.bo.impl.channelcust;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.GenericService;
import com.dcsoft.capmkt.bo.intf.IChannelCustomerService;
import com.dcsoft.capmkt.orm.dao.impl.ChannelCustomerDAO;

@Service
public class ChannelCustomerServiceImpl extends GenericService implements IChannelCustomerService {

	private ChannelCustomerDAO channelCustomerDao;
	@Override
	@Transactional
	public List<Serializable> list() {
		return getGenericDao().list("ChChannelCustomer");
	}

	@Override
	@Transactional
	public List<Serializable> findByExample(Class<?> clazz, Serializable obj) {
		return null;
	}

	public ChannelCustomerDAO getChannelCustomerDao() {
		return channelCustomerDao;
	}

	public void setChannelCustomerDao(ChannelCustomerDAO channelCustomerDao) {
		this.channelCustomerDao = channelCustomerDao;
	}

}
