package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

public class ChHostTO extends Model{
	
	private static final long serialVersionUID = -4175813615917320332L;
	private BigDecimal hostId;
	private String hostName;
	private String hostDescription;
	private String hostCountryCode;
	public BigDecimal getHostId() {
		return hostId;
	}
	public void setHostId(BigDecimal hostId) {
		this.hostId = hostId;
	}
	@NotEmpty
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	@NotEmpty
	public String getHostDescription() {
		return hostDescription;
	}
	public void setHostDescription(String hostDescription) {
		this.hostDescription = hostDescription;
	}
	public String getHostCountryCode() {
		return hostCountryCode;
	}
	public void setHostCountryCode(String hostCountryCode) {
		this.hostCountryCode = hostCountryCode;
	}

}
