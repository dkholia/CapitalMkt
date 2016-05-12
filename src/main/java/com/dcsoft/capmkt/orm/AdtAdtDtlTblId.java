package com.dcsoft.capmkt.orm;
// Generated Apr 7, 2016 1:42:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AdtAdtDtlTblId generated by hbm2java
 */
@Embeddable
public class AdtAdtDtlTblId implements java.io.Serializable {

	private String adtBaseTblIdent;
	private String adtAdtTblIdent;
	private String adtOnlAdtInd;
	private String adtBchAdtInd;
	private String adtBkgAdtInd;
	private Date adtCrtUpdtDt;
	private String adtUserid;
	private String adtDelSta;
	private String branchid;

	public AdtAdtDtlTblId() {
	}

	public AdtAdtDtlTblId(String adtBaseTblIdent, String adtAdtTblIdent, String adtOnlAdtInd, String adtBchAdtInd,
			String adtBkgAdtInd, Date adtCrtUpdtDt, String adtUserid, String adtDelSta, String branchid) {
		this.adtBaseTblIdent = adtBaseTblIdent;
		this.adtAdtTblIdent = adtAdtTblIdent;
		this.adtOnlAdtInd = adtOnlAdtInd;
		this.adtBchAdtInd = adtBchAdtInd;
		this.adtBkgAdtInd = adtBkgAdtInd;
		this.adtCrtUpdtDt = adtCrtUpdtDt;
		this.adtUserid = adtUserid;
		this.adtDelSta = adtDelSta;
		this.branchid = branchid;
	}

	@Column(name = "ADT_BASE_TBL_IDENT", length = 3)
	public String getAdtBaseTblIdent() {
		return this.adtBaseTblIdent;
	}

	public void setAdtBaseTblIdent(String adtBaseTblIdent) {
		this.adtBaseTblIdent = adtBaseTblIdent;
	}

	@Column(name = "ADT_ADT_TBL_IDENT", length = 3)
	public String getAdtAdtTblIdent() {
		return this.adtAdtTblIdent;
	}

	public void setAdtAdtTblIdent(String adtAdtTblIdent) {
		this.adtAdtTblIdent = adtAdtTblIdent;
	}

	@Column(name = "ADT_ONL_ADT_IND", length = 1)
	public String getAdtOnlAdtInd() {
		return this.adtOnlAdtInd;
	}

	public void setAdtOnlAdtInd(String adtOnlAdtInd) {
		this.adtOnlAdtInd = adtOnlAdtInd;
	}

	@Column(name = "ADT_BCH_ADT_IND", length = 1)
	public String getAdtBchAdtInd() {
		return this.adtBchAdtInd;
	}

	public void setAdtBchAdtInd(String adtBchAdtInd) {
		this.adtBchAdtInd = adtBchAdtInd;
	}

	@Column(name = "ADT_BKG_ADT_IND", length = 1)
	public String getAdtBkgAdtInd() {
		return this.adtBkgAdtInd;
	}

	public void setAdtBkgAdtInd(String adtBkgAdtInd) {
		this.adtBkgAdtInd = adtBkgAdtInd;
	}

	@Column(name = "ADT_CRT_UPDT_DT", length = 13)
	public Date getAdtCrtUpdtDt() {
		return this.adtCrtUpdtDt;
	}

	public void setAdtCrtUpdtDt(Date adtCrtUpdtDt) {
		this.adtCrtUpdtDt = adtCrtUpdtDt;
	}

	@Column(name = "ADT_USERID", length = 101)
	public String getAdtUserid() {
		return this.adtUserid;
	}

	public void setAdtUserid(String adtUserid) {
		this.adtUserid = adtUserid;
	}

	@Column(name = "ADT_DEL_STA", length = 1)
	public String getAdtDelSta() {
		return this.adtDelSta;
	}

	public void setAdtDelSta(String adtDelSta) {
		this.adtDelSta = adtDelSta;
	}

	@Column(name = "BRANCHID", length = 2)
	public String getBranchid() {
		return this.branchid;
	}

	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AdtAdtDtlTblId))
			return false;
		AdtAdtDtlTblId castOther = (AdtAdtDtlTblId) other;

		return ((this.getAdtBaseTblIdent() == castOther.getAdtBaseTblIdent())
				|| (this.getAdtBaseTblIdent() != null && castOther.getAdtBaseTblIdent() != null
						&& this.getAdtBaseTblIdent().equals(castOther.getAdtBaseTblIdent())))
				&& ((this.getAdtAdtTblIdent() == castOther.getAdtAdtTblIdent())
						|| (this.getAdtAdtTblIdent() != null && castOther.getAdtAdtTblIdent() != null
								&& this.getAdtAdtTblIdent().equals(castOther.getAdtAdtTblIdent())))
				&& ((this.getAdtOnlAdtInd() == castOther.getAdtOnlAdtInd())
						|| (this.getAdtOnlAdtInd() != null && castOther.getAdtOnlAdtInd() != null
								&& this.getAdtOnlAdtInd().equals(castOther.getAdtOnlAdtInd())))
				&& ((this.getAdtBchAdtInd() == castOther.getAdtBchAdtInd())
						|| (this.getAdtBchAdtInd() != null && castOther.getAdtBchAdtInd() != null
								&& this.getAdtBchAdtInd().equals(castOther.getAdtBchAdtInd())))
				&& ((this.getAdtBkgAdtInd() == castOther.getAdtBkgAdtInd())
						|| (this.getAdtBkgAdtInd() != null && castOther.getAdtBkgAdtInd() != null
								&& this.getAdtBkgAdtInd().equals(castOther.getAdtBkgAdtInd())))
				&& ((this.getAdtCrtUpdtDt() == castOther.getAdtCrtUpdtDt())
						|| (this.getAdtCrtUpdtDt() != null && castOther.getAdtCrtUpdtDt() != null
								&& this.getAdtCrtUpdtDt().equals(castOther.getAdtCrtUpdtDt())))
				&& ((this.getAdtUserid() == castOther.getAdtUserid()) || (this.getAdtUserid() != null
						&& castOther.getAdtUserid() != null && this.getAdtUserid().equals(castOther.getAdtUserid())))
				&& ((this.getAdtDelSta() == castOther.getAdtDelSta()) || (this.getAdtDelSta() != null
						&& castOther.getAdtDelSta() != null && this.getAdtDelSta().equals(castOther.getAdtDelSta())))
				&& ((this.getBranchid() == castOther.getBranchid()) || (this.getBranchid() != null
						&& castOther.getBranchid() != null && this.getBranchid().equals(castOther.getBranchid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getAdtBaseTblIdent() == null ? 0 : this.getAdtBaseTblIdent().hashCode());
		result = 37 * result + (getAdtAdtTblIdent() == null ? 0 : this.getAdtAdtTblIdent().hashCode());
		result = 37 * result + (getAdtOnlAdtInd() == null ? 0 : this.getAdtOnlAdtInd().hashCode());
		result = 37 * result + (getAdtBchAdtInd() == null ? 0 : this.getAdtBchAdtInd().hashCode());
		result = 37 * result + (getAdtBkgAdtInd() == null ? 0 : this.getAdtBkgAdtInd().hashCode());
		result = 37 * result + (getAdtCrtUpdtDt() == null ? 0 : this.getAdtCrtUpdtDt().hashCode());
		result = 37 * result + (getAdtUserid() == null ? 0 : this.getAdtUserid().hashCode());
		result = 37 * result + (getAdtDelSta() == null ? 0 : this.getAdtDelSta().hashCode());
		result = 37 * result + (getBranchid() == null ? 0 : this.getBranchid().hashCode());
		return result;
	}

}