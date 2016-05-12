package com.dcsoft.capmkt.bo.intf;

import java.math.BigDecimal;

import com.dcsoft.capmkt.orm.ChUser;

public interface IChannelUserService extends IGenericService {
	public ChUser getUserDetails(BigDecimal id);
}
