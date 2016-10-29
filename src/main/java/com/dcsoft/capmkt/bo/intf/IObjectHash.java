package com.dcsoft.capmkt.bo.intf;

import java.math.BigDecimal;

import com.dcsoft.capmkt.bo.transferobj.Model;

public interface IObjectHash extends IGenericService{
	public void saveObjectHash(Class<? extends Model> clazz, String idColumnName, BigDecimal objectID, BigDecimal objectHash);
}
