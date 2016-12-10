package com.dcsoft.capmkt.bo.impl.group;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.ObjectHashImpl;
import com.dcsoft.capmkt.bo.intf.IChannelCustomerGrpMapping;
import com.dcsoft.capmkt.bo.intf.IGroupService;
import com.dcsoft.capmkt.bo.transferobj.ChGroupTO;
import com.dcsoft.capmkt.orm.ChGroup;
import com.dcsoft.capmkt.orm.dao.impl.GroupDAO;

@Service
public class GroupServiceImpl extends ObjectHashImpl implements IGroupService {
	
	private GroupDAO groupDao;
	
	@Override
	@Transactional
	public List<Serializable> findByExample(Class<?> clazz, Serializable obj) {
		ChGroupTO groupTO = (ChGroupTO) obj;
		ChGroup chGroup = new ChGroup();
		
		if(groupTO.getGroupName()!=null && groupTO.getGroupName()!=""){
			chGroup.setGroupName(groupTO.getGroupName());
		}
		return getGenericDao().findByExample(clazz, chGroup);
	}

	@Override
	@Transactional
	public void addGroup(ChGroupTO p) {
		ChGroup persistObj = new ChGroup();
		persistObj.setGroupName(p.getGroupName());
		persistObj.setGroupdesc(p.getGroupDesc());
		BigDecimal objectID = (BigDecimal) getGenericDao().add(persistObj);
		persistObj.setGroupId(objectID);
		//saveObjectHash(ChGroupTO.class, "ChGroup", persistObj.getGroupId(), new BigDecimal(persistObj.hashCode()));
	}

	@Override
	@Transactional
	public void updateGroup(ChGroupTO chGroupTO,IChannelCustomerGrpMapping chnlCustGrpMapService) {
		ChGroup presistObj = new ChGroup();
		presistObj.setGroupId(new BigDecimal(chGroupTO.getGroupId()));
		presistObj.setGroupName(chGroupTO.getGroupName());
		presistObj.setGroupdesc(chGroupTO.getGroupDesc());
		getGenericDao().update(presistObj);
		chnlCustGrpMapService.addChannelCustomersToGroup(new BigDecimal(chGroupTO.getGroupId().trim()), chGroupTO.getCustomers());
	}

	@Override
	@Transactional
	public List<Serializable> listGroups() {
		return getGenericDao().list("ChGroup");
	}

	@Override
	@Transactional
	public ChGroup getGroupById(BigDecimal id) {
		return (ChGroup) getGenericDao().getById(ChGroup.class,id.intValue());
	}

	@Override
	@Transactional
	public void removeGroup(BigDecimal id) {
		getGenericDao().remove(ChGroup.class,id.intValue());
	}

	@Override
	@Transactional
	public List<Serializable> list() {
		return getGenericDao().list("ChGroup");
	}

	public GroupDAO getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDAO groupDao) {
		this.groupDao = groupDao;
	}

	@Override
	@Transactional
	public ChGroup getGroupDetails(BigDecimal id) {
		return groupDao.getGroupDetails(id);
	}

	@Override
	@Transactional
	public List<Serializable> getGroupByCriteria(ChGroupTO chGroupTO) {
		ChGroup group = new ChGroup();
		group.setGroupName(chGroupTO.getGroupName().trim());
		return groupDao.getGroupByCriteria(group);
	}

}
