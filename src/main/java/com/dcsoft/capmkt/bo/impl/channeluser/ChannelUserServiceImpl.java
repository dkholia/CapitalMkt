package com.dcsoft.capmkt.bo.impl.channeluser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.GenericService;
import com.dcsoft.capmkt.bo.intf.IChannelUserService;
import com.dcsoft.capmkt.bo.transferobj.ChUserTO;
import com.dcsoft.capmkt.orm.ChDapUserMapping;
import com.dcsoft.capmkt.orm.ChDapUserMappingId;
import com.dcsoft.capmkt.orm.ChFapUserMapping;
import com.dcsoft.capmkt.orm.ChFapUserMappingId;
import com.dcsoft.capmkt.orm.ChUser;
import com.dcsoft.capmkt.orm.ChUserGroupMapping;
import com.dcsoft.capmkt.orm.ChUserGroupMappingId;
import com.dcsoft.capmkt.orm.dao.impl.ChannelUserDAO;
import com.dcsoft.capmkt.orm.dao.impl.ChannelUserDapMappingDAO;
import com.dcsoft.capmkt.orm.dao.impl.ChannelUserFapMappingDAO;
import com.dcsoft.capmkt.orm.dao.impl.ChannelUserGroupMappingDAO;

@Service
public class ChannelUserServiceImpl extends GenericService implements IChannelUserService {

	private ChannelUserDAO channelUserDao;
	private ChannelUserGroupMappingDAO userGroupMapDAO;
	private ChannelUserFapMappingDAO userFapMapDAO;
	private ChannelUserDapMappingDAO userDapMapDAO;
	
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

	@Override
	@Transactional
	public boolean addUser(ChUserTO chUserTO) {
		ChUser chUser = new ChUser();
		chUser.setUname(chUserTO.getLoginid());
		chUser.setUpwd(chUserTO.getLoginid());
		chUser.setFirstname(chUserTO.getFname());
		chUser.setMiddlename(chUserTO.getMname());
		chUser.setLasname(chUserTO.getLname());
		chUser.setDatecreated(Calendar.getInstance().getTime());
		chUser.setIsactive(true);
		chUser.setUsertyp("nonadmin");
		getGenericDao().add(chUser);
		return true;
	}

	@Override
	@Transactional
	public List<Serializable> getUserByLoginID(String loginID) {
		ChUser user = new ChUser();
		user.setUname(loginID);
		user.setIsactive(true);
		return  getGenericDao().findByExample(ChUser.class, user);
	}

	@Override
	@Transactional
	public void removeUser(BigDecimal id) {
		getGenericDao().remove(ChUser.class, id.intValue());
	}

	@Override
	@Transactional
	public List<Serializable> getUserByExample(ChUserTO userTO) {
		ChUser user = new ChUser();
		boolean searchCriteriaProvided=false;
		if(userTO.getLoginid()!=null && userTO.getLoginid().trim()!=""){
			user.setUname(userTO.getLoginid().trim());
			searchCriteriaProvided=true;
		}
		
		if(userTO.getFname()!=null && userTO.getFname().trim()!=""){
			user.setFirstname(userTO.getFname().trim());
			searchCriteriaProvided=true;
		}
		user.setIsactive(true);
		if(!searchCriteriaProvided)
				return null;
		return getChannelUserDao().findByExample(ChUser.class, user);
	}

	public ChannelUserGroupMappingDAO getUserGroupMapDAO() {
		return userGroupMapDAO;
	}

	public void setUserGroupMapDAO(ChannelUserGroupMappingDAO userGroupMapDAO) {
		this.userGroupMapDAO = userGroupMapDAO;
	}

	public ChannelUserFapMappingDAO getUserFapMapDAO() {
		return userFapMapDAO;
	}

	public void setUserFapMapDAO(ChannelUserFapMappingDAO userFapMapDAO) {
		this.userFapMapDAO = userFapMapDAO;
	}

	public ChannelUserDapMappingDAO getUserDapMapDAO() {
		return userDapMapDAO;
	}

	public void setUserDapMapDAO(ChannelUserDapMappingDAO userDapMapDAO) {
		this.userDapMapDAO = userDapMapDAO;
	}

	@Override
	@Transactional
	public void attachGroupsToUser(BigDecimal userID, List<BigDecimal> groupIDs) {
		ChUserGroupMapping mapping = null;
		ChUserGroupMappingId id ;
		for(BigDecimal groupID : groupIDs){
			id = new ChUserGroupMappingId(groupID, userID);
			mapping = new ChUserGroupMapping(id);
			getGenericDao().add(mapping);
		}
	
	}

	@Override
	@Transactional
	public void attachFapsToUser(BigDecimal userID, List<BigDecimal> fapIDs) {
		ChFapUserMapping mapping;
		ChFapUserMappingId id ;
		for(BigDecimal fapID : fapIDs){
			id = new ChFapUserMappingId(userID, fapID);
			mapping = new ChFapUserMapping(id);
			getGenericDao().add(mapping);
		}
	}

	@Override
	@Transactional
	public void attachDapsToUser(BigDecimal userID, List<BigDecimal> dapIDs) {
		ChDapUserMapping mapping;
		ChDapUserMappingId id ;
		for(BigDecimal dapID : dapIDs){
			id = new ChDapUserMappingId(userID,dapID);
			mapping = new ChDapUserMapping(id);
			getGenericDao().add(mapping);
		}
	}

}
