package com.dcsoft.capmkt.orm;
// Generated Apr 7, 2016 1:42:57 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DsDomains generated by hbm2java
 */
@Entity
@Table(name = "ds_domains", schema = "public")
public class DsDomains implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 740591457120954341L;
	private DsDomainsId id;

	public DsDomains() {
	}

	public DsDomains(DsDomainsId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "dmndomain", column = @Column(name = "dmndomain", length = 40)),
			@AttributeOverride(name = "dmndomainval", column = @Column(name = "dmndomainval", length = 40)),
			@AttributeOverride(name = "dmndomaindesc", column = @Column(name = "dmndomaindesc")),
			@AttributeOverride(name = "dmndomainvaldesc", column = @Column(name = "dmndomainvaldesc")),
			@AttributeOverride(name = "createdby", column = @Column(name = "createdby", length = 101)),
			@AttributeOverride(name = "createddate", column = @Column(name = "createddate", length = 13)) })
	public DsDomainsId getId() {
		return this.id;
	}

	public void setId(DsDomainsId id) {
		this.id = id;
	}

}
