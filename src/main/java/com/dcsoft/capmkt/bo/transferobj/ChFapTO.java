package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
	private List<BigDecimal> servicesassoc = new ArrayList<BigDecimal>();
	@NotEmpty
	private List<BigDecimal> linkedServices = new ArrayList<BigDecimal>();
	
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
	public List<BigDecimal> getLinkedServices() {
		return linkedServices;
	}
	public void setLinkedServices(List<BigDecimal> linkedServices) {
		this.linkedServices = linkedServices;
	}
	@Override
	public int hashCode() {
		Random generator = new Random(999999999);
		int hashCode = generator.nextInt();
		
		if(fapName!=null && fapName.trim()!=""){
			hashCode += fapName.length()* fapName.hashCode(); 
		}
		if(fapDescription!=null && fapDescription.trim()!=""){
			hashCode += fapDescription.length()* fapDescription.hashCode(); 
		}
		if(servicesassoc!=null){
			for(BigDecimal serviceID : servicesassoc){
				hashCode += serviceID.intValueExact();
			}
		}
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
