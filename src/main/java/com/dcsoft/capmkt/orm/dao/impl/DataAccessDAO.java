package com.dcsoft.capmkt.orm.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.dcsoft.capmkt.orm.ChDap;

public class DataAccessDAO extends GenericDAOImpl  {

	@SuppressWarnings("unchecked")
	public List<Serializable> getDapByCriteria(ChDap chDap){
		
		Criteria criteria = getSession().createCriteria(chDap.getClass());
		if(null!=chDap.getDapName() && !chDap.getDapName().trim().equals("")){
			criteria.add(Restrictions.ilike("dapName", chDap.getDapName(), MatchMode.ANYWHERE));
		}
		if(null!=chDap.getChannelCustId() && !chDap.getChannelCustId().equals("")){
			criteria.add(Restrictions.eq("channelCustId", chDap.getChannelCustId()));
		}
		if (chDap.getDapName().trim().equals("") && chDap.getChannelCustId()==null){
			return null;
		}
		return criteria.list();
	}

	public Serializable getDataAccessDetails(BigDecimal id) {
		ChDap dap = (ChDap) getById(ChDap.class, id.intValue());
		getHibernateTemplate().initialize(dap.getChDapUserMappings());
		getHibernateTemplate().initialize(dap.getChDapCustMappings());
		return dap;
	}
}
