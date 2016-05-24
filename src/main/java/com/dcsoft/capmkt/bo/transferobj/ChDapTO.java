/**
 * 
 */
package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Deep
 */
public class ChDapTO extends Model {

	private static final long serialVersionUID = -3685887190715645847L;
	
	@NotEmpty
	private String dapName;
	private String dapDescription;
	private BigDecimal dapServiceId;
	private BigDecimal channelCustId;
	
	public String getDapName() {
		return dapName;
	}
	public String getDapDescription() {
		return dapDescription;
	}
	public BigDecimal getDapServiceId() {
		return dapServiceId;
	}
	public BigDecimal getChannelCustId() {
		return channelCustId;
	}
	public void setDapName(String dapName) {
		this.dapName = dapName;
	}
	public void setDapDescription(String dapDescription) {
		this.dapDescription = dapDescription;
	}
	public void setDapServiceId(BigDecimal dapServiceId) {
		this.dapServiceId = dapServiceId;
	}
	public void setChannelCustId(BigDecimal channelCustId) {
		this.channelCustId = channelCustId;
	}
}
