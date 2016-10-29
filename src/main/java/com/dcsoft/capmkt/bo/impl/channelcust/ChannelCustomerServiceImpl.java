package com.dcsoft.capmkt.bo.impl.channelcust;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.GenericService;
import com.dcsoft.capmkt.bo.impl.ObjectHashImpl;
import com.dcsoft.capmkt.bo.intf.IChannelCustomerService;
import com.dcsoft.capmkt.bo.transferobj.ChannelCustomerTO;
import com.dcsoft.capmkt.orm.ChChannelCustomer;
import com.dcsoft.capmkt.orm.dao.impl.ChannelCustomerDAO;

@Service
public class ChannelCustomerServiceImpl extends ObjectHashImpl implements IChannelCustomerService {

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

	@Override
	@Transactional
	public List<Serializable> getCustomerByExample(Serializable obj) {
		ChannelCustomerTO channelCustomerTO = (ChannelCustomerTO) obj;
		ChChannelCustomer customer = new ChChannelCustomer();
		customer.setChannelCustName(channelCustomerTO.getChannelCustName());
		return getGenericDao().findByExample(ChChannelCustomer.class,customer);
	}

	@Override
	@Transactional
	public boolean addCustomer(Serializable obj) {
		try {
			ChannelCustomerTO channelCustomerTO = (ChannelCustomerTO) obj;
			ChChannelCustomer customer = new ChChannelCustomer();
			customer.setChannelCustName(channelCustomerTO.getChannelCustName());
			customer.setChannelCustDesc(channelCustomerTO.getChannelCustDesc());
			getGenericDao().add(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@Transactional
	public Serializable getCustomerDetails(BigDecimal id) {
		return channelCustomerDao.getCustomerDetails(id);
	}
}
