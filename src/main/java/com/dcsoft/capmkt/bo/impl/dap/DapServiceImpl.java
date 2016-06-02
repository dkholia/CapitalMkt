package com.dcsoft.capmkt.bo.impl.dap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcsoft.capmkt.bo.impl.GenericService;
import com.dcsoft.capmkt.bo.intf.IDapService;
import com.dcsoft.capmkt.bo.transferobj.ChDapTO;
import com.dcsoft.capmkt.bo.transferobj.DropDown;
import com.dcsoft.capmkt.orm.ChChannelCustomer;
import com.dcsoft.capmkt.orm.ChDap;
import com.dcsoft.capmkt.orm.dao.impl.DataAccessDAO;

@Service
public class DapServiceImpl extends GenericService implements IDapService {

	private DataAccessDAO dapDAO;
	
	public DataAccessDAO getDapDAO() {
		return dapDAO;
	}

	public void setDapDAO(DataAccessDAO dapDAO) {
		this.dapDAO = dapDAO;
	}

	@Override
	@Transactional
	public List<Serializable> list() {
		return getGenericDao().list(ChDap.class.getName());
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

	@Override
	@Transactional
	public boolean addDataAccess(ChDapTO chDapTO) {
		try{
			ChDap chDap = new ChDap();
			chDap.setDapName(chDapTO.getDapName());
			chDap.setDapDescription(chDapTO.getDapDescription());
			chDap.setChannelCustId(chDapTO.getChannelCustId());
			getGenericDao().add(chDap);
			return true;	
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public List<Serializable> getDataAccessByName(String dapName) {
		ChDap dap = new ChDap();
		dap.setDapName(dapName);
		return getGenericDao().findByExample(ChDap.class, dap);
	}

	@Override
	@Transactional
	public List<Serializable> getDapByCriteria(Serializable obj) {
		ChDapTO dapTO = (ChDapTO) obj;
		ChDap dap = new ChDap();
		dap.setDapName(dapTO.getDapName());
		dap.setChannelCustId(dapTO.getChannelCustId());
		return getDapDAO().getDapByCriteria(dap);
	}

}
