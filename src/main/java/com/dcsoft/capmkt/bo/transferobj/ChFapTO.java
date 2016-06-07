package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class ChFapTO extends Model {

	private static final long serialVersionUID = 1344557462025403778L;
	private BigDecimal fapId;
	private short channel;
	private BigDecimal createdBy;
	private Date createdDate;
	@NotEmpty
	private String fapDescription;
	@NotEmpty
	private String fapName;
	@NotEmpty
	private List<BigDecimal> servicesassoc = new ArrayList<BigDecimal>();
	private List<Integer> linkedServices = new ArrayList<Integer>();
	
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
	public List<BigDecimal> getServicesassoc() {
		return servicesassoc;
	}
	public void setServicesassoc(List<BigDecimal> servicesassoc) {
		this.servicesassoc = servicesassoc;
	}
	public List<Integer> getLinkedServices() {
		return linkedServices;
	}
	public void setLinkedServices(List<Integer> linkedServices) {
		this.linkedServices = linkedServices;
	}
}
