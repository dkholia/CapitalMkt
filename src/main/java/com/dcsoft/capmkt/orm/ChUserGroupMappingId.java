package com.dcsoft.capmkt.orm;
// Generated Apr 7, 2016 1:42:57 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ChUserGroupMappingId generated by hbm2java
 */
@Embeddable
public class ChUserGroupMappingId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1748877013878878348L;
	private BigDecimal groupid;
	private BigDecimal userid;

	public ChUserGroupMappingId() {
	}

	public ChUserGroupMappingId(BigDecimal groupid, BigDecimal userid) {
		this.groupid = groupid;
		this.userid = userid;
	}

	@Column(name = "groupid", scale = 0)
	public BigDecimal getGroupid() {
		return this.groupid;
	}

	public void setGroupid(BigDecimal groupid) {
		this.groupid = groupid;
	}

	@Column(name = "userid", length = 20)
	public BigDecimal getUserid() {
		return this.userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ChUserGroupMappingId))
			return false;
		ChUserGroupMappingId castOther = (ChUserGroupMappingId) other;

		return ((this.getGroupid() == castOther.getGroupid()) || (this.getGroupid() != null
				&& castOther.getGroupid() != null && this.getGroupid().equals(castOther.getGroupid())))
				&& ((this.getUserid() == castOther.getUserid()) || (this.getUserid() != null
						&& castOther.getUserid() != null && this.getUserid().equals(castOther.getUserid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getGroupid() == null ? 0 : this.getGroupid().hashCode());
		result = 37 * result + (getUserid() == null ? 0 : this.getUserid().hashCode());
		return result;
	}

}
