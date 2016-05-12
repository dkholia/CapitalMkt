package com.dcsoft.capmkt.orm.dao.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.dcsoft.capmkt.bo.transferobj.ChGroupTO;
import com.dcsoft.capmkt.bo.transferobj.ChannelCustomerTO;
import com.dcsoft.capmkt.orm.ChChannelCustGrpMapping;
import com.dcsoft.capmkt.orm.ChChannelCustomer;
import com.dcsoft.capmkt.orm.ChGroup;
import com.dcsoft.capmkt.orm.dao.impl.GroupDAO;

public class GroupManager extends HibernateDaoSupport implements Serializable {

	private static final long serialVersionUID = -350984146636358515L;
	
	private GroupDAO groupDAO= new GroupDAO();
	
	public ChGroup getGroupDetails(int iGroupID){
		ChGroup group = (ChGroup) groupDAO.getById(ChGroup.class, iGroupID);
		getHibernateTemplate().initialize(group.getChChannelCustGrpMappings());
		getHibernateTemplate().initialize(group.getChUserGroupMappings());
		return group;
	}

	public GroupDAO getGroupDAO() {
		return groupDAO;
	}

	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}
	
	public ChGroupTO convertToChGroupTOFromChgroup(ChGroup group) {
		ChGroupTO groupTO = new ChGroupTO();
		groupTO.setGroupId(group.getGroupId().toString());
		groupTO.setGroupName(group.getGroupName());
		groupTO.setGroupDesc(group.getGroupdesc());
		return groupTO;
	}
	
	public List<ChannelCustomerTO> getAllChannelCustomers(List<Serializable> allCustomers,Set<ChChannelCustGrpMapping> connectedCustomers ){
		HashMap<String, ChChannelCustomer> customerMap = new HashMap<String, ChChannelCustomer>();
		List<ChannelCustomerTO> returnList = new ArrayList<ChannelCustomerTO>();
		
		Iterator<ChChannelCustGrpMapping> mappingIterator = connectedCustomers.iterator();
		while (mappingIterator.hasNext()) {
			ChChannelCustGrpMapping type =  mappingIterator.next();
			ChChannelCustomer customer = type.getChChannelCustomer();
			customerMap.put(customer.getChannelCustId().toString(),customer);
		}
		
		for(int i =0; i<allCustomers.size();i++){
			ChannelCustomerTO temp = new ChannelCustomerTO();
			ChChannelCustomer cust = (ChChannelCustomer) allCustomers.get(i);
			temp.setChannelCustId(cust.getChannelCustId());
			temp.setChannelCustName(cust.getChannelCustName());
			temp.setChannelCustDesc(cust.getChannelCustDesc());
			if(customerMap.get(temp.getChannelCustId().toString())!=null){
				temp.setSelected(true);
			}else{
				temp.setSelected(false);
			}
			returnList.add(temp);
		}
		return returnList;
	}
}
