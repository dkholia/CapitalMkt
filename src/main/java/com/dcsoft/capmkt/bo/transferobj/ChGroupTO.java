package com.dcsoft.capmkt.bo.transferobj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


public class ChGroupTO extends Model {

	private static final long serialVersionUID = 8900761267253248095L;
	
	//@NotEmpty
	private String groupId;
	@NotEmpty
	@Size(max=10, min=2)
	private String groupName;
	@NotEmpty
	private String groupDesc;
	//@NotEmpty
	private String createdby;
	//@NotEmpty
	@DateTimeFormat(pattern="mm/dd/yyyy z hh:mm:ss a")
	private String creationdate;
	
	@NotEmpty
	private List<BigDecimal> customers = new ArrayList<BigDecimal>();
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
	public List<BigDecimal> getCustomers() {
		return customers;
	}
	public void setCustomers(List<BigDecimal> customers) {
		this.customers = customers;
	}
	
	public int hashCode() {
		Random generator = new Random();
		int hashCode = Math.abs(generator.nextInt(Integer.MAX_VALUE));
		
		if(groupName!=null && groupName.trim()!=""){
			hashCode += groupName.length()* groupName.hashCode(); 
		}
		if(groupDesc!=null && groupDesc.trim()!=""){
			hashCode += groupDesc.length()* groupDesc.hashCode(); 
		}
		if(customers!=null){
			for(int i=0;i<customers.size();i++){
				hashCode+=customers.get(i).intValue();
			}
		}
		
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
