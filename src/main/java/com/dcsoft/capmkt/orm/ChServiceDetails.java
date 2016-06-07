package com.dcsoft.capmkt.orm;
// Generated Apr 7, 2016 1:42:57 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ChServiceDetails generated by hbm2java
 */
@Entity
@Table(name = "ch_service_details", schema = "public")
public class ChServiceDetails implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9170600768404958067L;
	private int serviceDetailId;
	private ChHost chHost;
	private String serviceId;
	private String description;
	private Integer serviceType;
	private String namespace;
	private Integer channel;
	private String actionAlias;
	private String param1;
	private String param2;
	private String param3;
	private String param4;
	private String param5;
	private String fieldId;

	public ChServiceDetails() {
	}

	public ChServiceDetails(int serviceDetailId, String serviceId, Integer serviceType) {
		this.serviceDetailId = serviceDetailId;
		this.serviceId = serviceId;
		this.serviceType = serviceType;
	}

	public ChServiceDetails(int serviceDetailId, ChHost chHost, String serviceId, String description, Integer serviceType,
			String namespace, Integer channel, String actionAlias, String param1, String param2, String param3,
			String param4, String param5, String fieldId) {
		this.serviceDetailId = serviceDetailId;
		this.chHost = chHost;
		this.serviceId = serviceId;
		this.description = description;
		this.serviceType = serviceType;
		this.namespace = namespace;
		this.channel = channel;
		this.actionAlias = actionAlias;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
		this.param4 = param4;
		this.param5 = param5;
		this.fieldId = fieldId;
	}

	@Id
	@GeneratedValue
	@Column(name = "service_detail_id", unique = true, nullable = false, precision = 8, scale = 0)
	public int getServiceDetailId() {
		return this.serviceDetailId;
	}

	public void setServiceDetailId(int serviceDetailId) {
		this.serviceDetailId = serviceDetailId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "host_id")
	public ChHost getChHost() {
		return this.chHost;
	}

	public void setChHost(ChHost chHost) {
		this.chHost = chHost;
	}

	@Column(name = "service_id", nullable = false, length = 100)
	public String getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "service_type", nullable = false, precision = 2, scale = 0)
	public Integer getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Integer i) {
		this.serviceType = i;
	}

	@Column(name = "namespace", length = 20)
	public String getNamespace() {
		return this.namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@Column(name = "channel", precision = 1, scale = 0)
	public Integer getChannel() {
		return this.channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	@Column(name = "action_alias", length = 100)
	public String getActionAlias() {
		return this.actionAlias;
	}

	public void setActionAlias(String actionAlias) {
		this.actionAlias = actionAlias;
	}

	@Column(name = "param1", length = 100)
	public String getParam1() {
		return this.param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	@Column(name = "param2", length = 100)
	public String getParam2() {
		return this.param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	@Column(name = "param3", length = 100)
	public String getParam3() {
		return this.param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	@Column(name = "param4", length = 100)
	public String getParam4() {
		return this.param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}

	@Column(name = "param5", length = 100)
	public String getParam5() {
		return this.param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
	}

	@Column(name = "field_id", length = 80)
	public String getFieldId() {
		return this.fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

}
