package com.dcsoft.capmkt.bo.intf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.dcsoft.capmkt.orm.ChUser;

public interface LoginService {
	public List<Serializable> findByExample(Serializable obj);
	public ChUser getUserDetailsByID(BigDecimal userID) throws Exception;
	public ChUser getUserDetails(ChUser user) throws Exception;
}
