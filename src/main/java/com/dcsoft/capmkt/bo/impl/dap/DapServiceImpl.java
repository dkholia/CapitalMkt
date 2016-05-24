package com.dcsoft.capmkt.bo.impl.dap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.GenericService;
import com.dcsoft.capmkt.bo.intf.IDapService;
import com.dcsoft.capmkt.bo.transferobj.DropDown;
import com.dcsoft.capmkt.orm.ChChannelCustomer;

@Service
public class DapServiceImpl extends GenericService implements IDapService {

	@Override
	public List<Serializable> list() {
		return null;
	}

	@Override
	public List<Serializable> findByExample(Class<?> clazz, Serializable obj) {
		return null;
	}

	@Override
	@Transactional
	public List<Serializable> getChannelCustomersDropDown() {
		List<Serializable> customers = getGenericDao().list("ChChannelCustomer");
		List<Serializable> dropDowns = new ArrayList<Serializable>();
		DropDown dropDown =null;
		for(int i=0;i<customers.size();i++){
			ChChannelCustomer customer = (ChChannelCustomer) customers.get(i);
			dropDown = new DropDown(customer.getChannelCustId().toPlainString(),customer.getChannelCustName()+ " " +(customer.getChannelCustDesc().trim().length()>0?(" :: "+  customer.getChannelCustDesc())  : ""));
			dropDowns.add(dropDown);
		}
		return dropDowns;
	}

}
