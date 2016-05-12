package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;

public class ChannelCustomerTO extends Model {

	private static final long serialVersionUID = -2611434515215996881L;

	private BigDecimal channelCustId;
	private String channelCustName;
	private String channelCustDesc;
	private boolean selected;
	
	public String getChannelCustName() {
		return channelCustName;
	}
	public void setChannelCustName(String channelCustName) {
		this.channelCustName = channelCustName;
	}
	public String getChannelCustDesc() {
		return channelCustDesc;
	}
	public void setChannelCustDesc(String channelCustDesc) {
		this.channelCustDesc = channelCustDesc;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean isSelected) {
		this.selected = isSelected;
	}
	
	public BigDecimal getChannelCustId() {
		return channelCustId;
	}
	public void setChannelCustId(BigDecimal channelCustId) {
		this.channelCustId = channelCustId;
	}
}
