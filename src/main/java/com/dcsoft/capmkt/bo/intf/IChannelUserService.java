package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.dcsoft.capmkt.bo.transferobj.ChUserTO;
import com.dcsoft.capmkt.orm.ChUser;

public interface IChannelUserService extends IGenericService {
	public ChUser getUserDetails(BigDecimal id);
	public boolean addUser(ChUserTO chUserTO);
	public List<Serializable> getUserByLoginID(String loginID);
	public void removeUser(BigDecimal id);
	public List<Serializable> getUserByExample(ChUserTO userTO);
	
	public void attachGroupsToUser(BigDecimal userID , List<BigDecimal> groupIDs);
	public void attachFapsToUser(BigDecimal userID , List<BigDecimal> fapIDs);
	public void attachDapsToUser(BigDecimal userID , List<BigDecimal> dapIDs);
	
	 public void saveObjectHash(String name, String objectID, String objectHash);
}
