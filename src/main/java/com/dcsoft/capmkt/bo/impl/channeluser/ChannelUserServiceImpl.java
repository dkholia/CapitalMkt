package com.dcsoft.capmkt.bo.impl.channeluser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.GenericService;
import com.dcsoft.capmkt.bo.intf.IChannelUserService;
import com.dcsoft.capmkt.orm.ChUser;
import com.dcsoft.capmkt.orm.dao.impl.ChannelUserDAO;

@Service
public class ChannelUserServiceImpl extends GenericService implements IChannelUserService {

	private ChannelUserDAO channelUserDao;
	@Override
	@Transactional
	public List<Serializable> list() {
		return getGenericDao().list("ChUser");
	}

	@Override
	@Transactional
	public List<Serializable> findByExample(Class<?> clazz, Serializable obj) {
		return null;
	}

	public ChannelUserDAO getChannelUserDao() {
		return channelUserDao;
	}

	public void setChannelUserDao(ChannelUserDAO channelUserDao) {
		this.channelUserDao = channelUserDao;
	}

	@Override
	@Transactional
	public ChUser getUserDetails(BigDecimal id) {
		return channelUserDao.getUserDetails(id);
	}

}
