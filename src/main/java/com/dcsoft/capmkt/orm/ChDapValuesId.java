package com.dcsoft.capmkt.orm;
// Generated May 22, 2016 10:33:07 PM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ChDapValuesId generated by hbm2java
 */
@Embeddable
public class ChDapValuesId implements java.io.Serializable {

	private static final long serialVersionUID = -6027706509345554885L;
	private Integer dapId;
	private String dapValue;

	public ChDapValuesId() {
	}

	public ChDapValuesId(Integer dapId, String dapValue) {
		this.dapId = dapId;
		this.dapValue = dapValue;
	}

	@Column(name = "dap_id")
	public Integer getDapId() {
		return this.dapId;
	}

	public void setDapId(Integer dapId) {
		this.dapId = dapId;
	}

	@Column(name = "dap_value")
	public String getDapValue() {
		return this.dapValue;
	}

	public void setDapValue(String dapValue) {
		this.dapValue = dapValue;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ChDapValuesId))
			return false;
		ChDapValuesId castOther = (ChDapValuesId) other;

		return ((this.getDapId() == castOther.getDapId()) || (this.getDapId() != null && castOther.getDapId() != null
				&& this.getDapId().equals(castOther.getDapId())))
				&& ((this.getDapValue() == castOther.getDapValue()) || (this.getDapValue() != null
						&& castOther.getDapValue() != null && this.getDapValue().equals(castOther.getDapValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDapId() == null ? 0 : this.getDapId().hashCode());
		result = 37 * result + (getDapValue() == null ? 0 : this.getDapValue().hashCode());
		return result;
	}

}