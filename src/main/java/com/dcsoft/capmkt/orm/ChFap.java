package com.dcsoft.capmkt.orm;
// Generated May 21, 2016 1:43:35 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ChFap generated by hbm2java
 */
@Entity
@Table(name = "ch_fap", schema = "public")
public class ChFap implements java.io.Serializable {

	private static final long serialVersionUID = 8294895168220369801L;

	private BigDecimal fapId;
	private short channel;
	private BigDecimal createdBy;
	private Date createdDate;
	private String fapDescription;
	private String fapName;
	private Set<ChServiceDetails> chServiceDetailses = new HashSet<ChServiceDetails>(0);
	private Set<ChFapUserMapping> chFapUserMappings = new HashSet<ChFapUserMapping>(0);

	public ChFap() {}
	
	public ChFap(short channel) {
		this.channel=channel;
	}

	public ChFap(BigDecimal fapId, short channel) {
		this.fapId = fapId;
		this.channel = channel;
	}

	public ChFap(BigDecimal fapId, short channel, BigDecimal createdBy, Date createdDate, String fapDescription,
			String fapName, Set<ChServiceDetails> chServiceDetailses, Set<ChFapUserMapping> chFapUserMappings) {
		this.fapId = fapId;
		this.channel = channel;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.fapDescription = fapDescription;
		this.fapName = fapName;
		this.chServiceDetailses = chServiceDetailses;
		this.chFapUserMappings = chFapUserMappings;
	}

	@Id
	@GeneratedValue
	@Column(name = "fap_id", unique = true, nullable = false)
	public BigDecimal getFapId() {
		return this.fapId;
	}

	public void setFapId(BigDecimal fapId) {
		this.fapId = fapId;
	}

	@Column(name = "channel", nullable = false)
	public short getChannel() {
		return this.channel;
	}

	public void setChannel(short channel) {
		this.channel = channel;
	}

	@Column(name = "created_by")
	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_date", length = 13)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "fap_description", length = 200)
	public String getFapDescription() {
		return this.fapDescription;
	}

	public void setFapDescription(String fapDescription) {
		this.fapDescription = fapDescription;
	}

	@Column(name = "fap_name", length = 100)
	public String getFapName() {
		return this.fapName;
	}

	public void setFapName(String fapName) {
		this.fapName = fapName;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ch_fap_service_mapping", schema = "public", joinColumns = {
			@JoinColumn(name = "fap_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "service_detail_id", nullable = false, updatable = false) })
	public Set<ChServiceDetails> getChServiceDetailses() {
		return this.chServiceDetailses;
	}

	public void setChServiceDetailses(Set<ChServiceDetails> chServiceDetailses) {
		this.chServiceDetailses = chServiceDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chFap")
	public Set<ChFapUserMapping> getChFapUserMappings() {
		return this.chFapUserMappings;
	}

	public void setChFapUserMappings(Set<ChFapUserMapping> chFapUserMappings) {
		this.chFapUserMappings = chFapUserMappings;
	}

}
