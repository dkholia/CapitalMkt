package com.dcsoft.capmkt.bo.transferobj;

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
}
