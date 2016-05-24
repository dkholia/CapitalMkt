package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ChannelCustomerTO extends Model {

	private static final long serialVersionUID = -2611434515215996881L;
	
	private BigDecimal channelCustId;
	@NotEmpty/* @Pattern(regexp="^[a-zA-Z0-9]$")*/
	@Size(min=1,max=50)
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
