package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;
import java.util.Date;

public class ChFapTO extends Model {

	private static final long serialVersionUID = 1344557462025403778L;
	private BigDecimal fapId;
	private short channel;
	private BigDecimal createdBy;
	private Date createdDate;
	private String fapDescription;
	private String fapName;
	public BigDecimal getFapId() {
		return fapId;
	}
	public short getChannel() {
		return channel;
	}
	public BigDecimal getCreatedBy() {
		return createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public String getFapDescription() {
		return fapDescription;
	}
	public String getFapName() {
		return fapName;
	}
	public void setFapId(BigDecimal fapId) {
		this.fapId = fapId;
	}
	public void setChannel(short channel) {
		this.channel = channel;
	}
	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setFapDescription(String fapDescription) {
		this.fapDescription = fapDescription;
	}
	public void setFapName(String fapName) {
		this.fapName = fapName;
	}
}
