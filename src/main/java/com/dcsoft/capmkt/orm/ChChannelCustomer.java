package com.dcsoft.capmkt.orm;
// Generated Apr 7, 2016 1:42:57 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ChChannelCustomer generated by hbm2java
 */
@Entity
@Table(name = "ch_channel_customer", schema = "public")
public class ChChannelCustomer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5993748139350819169L;
	private BigDecimal channelCustId;
	private String channelCustName;
	private String channelCustDesc;
	private Set chChannelCustGrpMappings = new HashSet(0);

	public ChChannelCustomer() {
	}

	public ChChannelCustomer(BigDecimal channelCustId) {
		this.channelCustId = channelCustId;
	}

	public ChChannelCustomer(BigDecimal channelCustId, String channelCustName, String channelCustDesc,
			Set chChannelCustGrpMappings) {
		this.channelCustId = channelCustId;
		this.channelCustName = channelCustName;
		this.channelCustDesc = channelCustDesc;
		this.chChannelCustGrpMappings = chChannelCustGrpMappings;
	}

	@Id

	@Column(name = "channel_cust_id", unique = true, nullable = false, scale = 0)
	public BigDecimal getChannelCustId() {
		return this.channelCustId;
	}

	public void setChannelCustId(BigDecimal channelCustId) {
		this.channelCustId = channelCustId;
	}

	@Column(name = "channel_cust_name")
	public String getChannelCustName() {
		return this.channelCustName;
	}

	public void setChannelCustName(String channelCustName) {
		this.channelCustName = channelCustName;
	}

	@Column(name = "channel_cust_desc", length = 1024)
	public String getChannelCustDesc() {
		return this.channelCustDesc;
	}

	public void setChannelCustDesc(String channelCustDesc) {
		this.channelCustDesc = channelCustDesc;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "chChannelCustomer",targetEntity=com.dcsoft.capmkt.orm.ChChannelCustGrpMapping.class)
	public Set getChChannelCustGrpMappings() {
		return this.chChannelCustGrpMappings;
	}

	public void setChChannelCustGrpMappings(Set chChannelCustGrpMappings) {
		this.chChannelCustGrpMappings = chChannelCustGrpMappings;
	}

}
