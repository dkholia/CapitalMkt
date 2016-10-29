package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;
import java.util.Random;

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
	@Override
	public int hashCode() {
		Random generator = new Random(999999999);
		int hashCode = generator.nextInt();
		
		if(channelCustId!=null ){
			hashCode += channelCustId.intValue() + channelCustId.hashCode();
		} 
		if(channelCustName!=null && channelCustName.trim()!=""){
			hashCode += channelCustName.length()* channelCustName.hashCode(); 
		}
		if(channelCustDesc!=null && channelCustDesc.trim()!=""){
			hashCode += channelCustDesc.length()* channelCustDesc.hashCode(); 
		}
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
