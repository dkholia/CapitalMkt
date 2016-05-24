package com.dcsoft.capmkt.orm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.dcsoft.capmkt.orm.ChFap;

public class ServiceAccessDAO extends GenericDAOImpl  {
	
	@SuppressWarnings("unchecked")
	public List<Serializable> getFapByCriteria(ChFap chFap){
		if(chFap.getFapName()==null || chFap.getFapName().trim().equals("")){
			return findByExample(ChFap.class,  new ChFap((short) 1));
		}else{
			return getSession().createCriteria(chFap.getClass())
					.add(Restrictions.ilike("fapName", chFap.getFapName(), MatchMode.ANYWHERE))
						.add(Restrictions.eq("channel", chFap.getChannel())).list();
		}
	}
}
