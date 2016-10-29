package com.dcsoft.capmkt.bo.intf;

import java.math.BigDecimal;
import java.util.List;

public interface IChannelCustomerGrpMapping extends IObjectHash {
	public void addChannelCustomersToGroup(BigDecimal groupId, List<BigDecimal> customers);
}
