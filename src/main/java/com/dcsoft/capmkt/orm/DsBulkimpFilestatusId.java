package com.dcsoft.capmkt.orm;
// Generated Apr 7, 2016 1:42:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DsBulkimpFilestatusId generated by hbm2java
 */
@Embeddable
public class DsBulkimpFilestatusId implements java.io.Serializable {

	private String bfsfilereferenceno;
	private String bfsgroupid;
	private String bfsfiletype;
	private String bfsdescription;
	private String createdby;
	private Date createddate;
	private String modifiedby;
	private Date modifieddate;
	private Long versionnum;
	private String bfsorgfilename;
	private String bfsfilehash;
	private String status;
	private String serviceloc;
	private String filesize;
	private String filetype;
	private String bfsorgauthfilename;
	private String authorizeby;
	private Date authorizedate;
	private Integer transactionno;

	public DsBulkimpFilestatusId() {
	}

	public DsBulkimpFilestatusId(String bfsfilereferenceno, String bfsgroupid, String bfsfiletype,
			String bfsdescription, String createdby, Date createddate, String modifiedby, Date modifieddate,
			Long versionnum, String bfsorgfilename, String bfsfilehash, String status, String serviceloc,
			String filesize, String filetype, String bfsorgauthfilename, String authorizeby, Date authorizedate,
			Integer transactionno) {
		this.bfsfilereferenceno = bfsfilereferenceno;
		this.bfsgroupid = bfsgroupid;
		this.bfsfiletype = bfsfiletype;
		this.bfsdescription = bfsdescription;
		this.createdby = createdby;
		this.createddate = createddate;
		this.modifiedby = modifiedby;
		this.modifieddate = modifieddate;
		this.versionnum = versionnum;
		this.bfsorgfilename = bfsorgfilename;
		this.bfsfilehash = bfsfilehash;
		this.status = status;
		this.serviceloc = serviceloc;
		this.filesize = filesize;
		this.filetype = filetype;
		this.bfsorgauthfilename = bfsorgauthfilename;
		this.authorizeby = authorizeby;
		this.authorizedate = authorizedate;
		this.transactionno = transactionno;
	}

	@Column(name = "BFSFILEREFERENCENO", length = 30)
	public String getBfsfilereferenceno() {
		return this.bfsfilereferenceno;
	}

	public void setBfsfilereferenceno(String bfsfilereferenceno) {
		this.bfsfilereferenceno = bfsfilereferenceno;
	}

	@Column(name = "BFSGROUPID", length = 15)
	public String getBfsgroupid() {
		return this.bfsgroupid;
	}

	public void setBfsgroupid(String bfsgroupid) {
		this.bfsgroupid = bfsgroupid;
	}

	@Column(name = "BFSFILETYPE", length = 50)
	public String getBfsfiletype() {
		return this.bfsfiletype;
	}

	public void setBfsfiletype(String bfsfiletype) {
		this.bfsfiletype = bfsfiletype;
	}

	@Column(name = "BFSDESCRIPTION")
	public String getBfsdescription() {
		return this.bfsdescription;
	}

	public void setBfsdescription(String bfsdescription) {
		this.bfsdescription = bfsdescription;
	}

	@Column(name = "CREATEDBY", length = 101)
	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name = "CREATEDDATE", length = 13)
	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	@Column(name = "MODIFIEDBY", length = 101)
	public String getModifiedby() {
		return this.modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	@Column(name = "MODIFIEDDATE", length = 13)
	public Date getModifieddate() {
		return this.modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	@Column(name = "VERSIONNUM", precision = 10, scale = 0)
	public Long getVersionnum() {
		return this.versionnum;
	}

	public void setVersionnum(Long versionnum) {
		this.versionnum = versionnum;
	}

	@Column(name = "BFSORGFILENAME", length = 200)
	public String getBfsorgfilename() {
		return this.bfsorgfilename;
	}

	public void setBfsorgfilename(String bfsorgfilename) {
		this.bfsorgfilename = bfsorgfilename;
	}

	@Column(name = "BFSFILEHASH", length = 100)
	public String getBfsfilehash() {
		return this.bfsfilehash;
	}

	public void setBfsfilehash(String bfsfilehash) {
		this.bfsfilehash = bfsfilehash;
	}

	@Column(name = "STATUS", length = 25)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "SERVICELOC", length = 20)
	public String getServiceloc() {
		return this.serviceloc;
	}

	public void setServiceloc(String serviceloc) {
		this.serviceloc = serviceloc;
	}

	@Column(name = "FILESIZE", length = 20)
	public String getFilesize() {
		return this.filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	@Column(name = "FILETYPE", length = 20)
	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	@Column(name = "BFSORGAUTHFILENAME", length = 200)
	public String getBfsorgauthfilename() {
		return this.bfsorgauthfilename;
	}

	public void setBfsorgauthfilename(String bfsorgauthfilename) {
		this.bfsorgauthfilename = bfsorgauthfilename;
	}

	@Column(name = "AUTHORIZEBY", length = 101)
	public String getAuthorizeby() {
		return this.authorizeby;
	}

	public void setAuthorizeby(String authorizeby) {
		this.authorizeby = authorizeby;
	}

	@Column(name = "AUTHORIZEDATE", length = 13)
	public Date getAuthorizedate() {
		return this.authorizedate;
	}

	public void setAuthorizedate(Date authorizedate) {
		this.authorizedate = authorizedate;
	}

	@Column(name = "TRANSACTIONNO", precision = 8, scale = 0)
	public Integer getTransactionno() {
		return this.transactionno;
	}

	public void setTransactionno(Integer transactionno) {
		this.transactionno = transactionno;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DsBulkimpFilestatusId))
			return false;
		DsBulkimpFilestatusId castOther = (DsBulkimpFilestatusId) other;

		return ((this.getBfsfilereferenceno() == castOther.getBfsfilereferenceno())
				|| (this.getBfsfilereferenceno() != null && castOther.getBfsfilereferenceno() != null
						&& this.getBfsfilereferenceno().equals(castOther.getBfsfilereferenceno())))
				&& ((this.getBfsgroupid() == castOther.getBfsgroupid()) || (this.getBfsgroupid() != null
						&& castOther.getBfsgroupid() != null && this.getBfsgroupid().equals(castOther.getBfsgroupid())))
				&& ((this.getBfsfiletype() == castOther.getBfsfiletype())
						|| (this.getBfsfiletype() != null && castOther.getBfsfiletype() != null
								&& this.getBfsfiletype().equals(castOther.getBfsfiletype())))
				&& ((this.getBfsdescription() == castOther.getBfsdescription())
						|| (this.getBfsdescription() != null && castOther.getBfsdescription() != null
								&& this.getBfsdescription().equals(castOther.getBfsdescription())))
				&& ((this.getCreatedby() == castOther.getCreatedby()) || (this.getCreatedby() != null
						&& castOther.getCreatedby() != null && this.getCreatedby().equals(castOther.getCreatedby())))
				&& ((this.getCreateddate() == castOther.getCreateddate())
						|| (this.getCreateddate() != null && castOther.getCreateddate() != null
								&& this.getCreateddate().equals(castOther.getCreateddate())))
				&& ((this.getModifiedby() == castOther.getModifiedby()) || (this.getModifiedby() != null
						&& castOther.getModifiedby() != null && this.getModifiedby().equals(castOther.getModifiedby())))
				&& ((this.getModifieddate() == castOther.getModifieddate())
						|| (this.getModifieddate() != null && castOther.getModifieddate() != null
								&& this.getModifieddate().equals(castOther.getModifieddate())))
				&& ((this.getVersionnum() == castOther.getVersionnum()) || (this.getVersionnum() != null
						&& castOther.getVersionnum() != null && this.getVersionnum().equals(castOther.getVersionnum())))
				&& ((this.getBfsorgfilename() == castOther.getBfsorgfilename())
						|| (this.getBfsorgfilename() != null && castOther.getBfsorgfilename() != null
								&& this.getBfsorgfilename().equals(castOther.getBfsorgfilename())))
				&& ((this.getBfsfilehash() == castOther.getBfsfilehash())
						|| (this.getBfsfilehash() != null && castOther.getBfsfilehash() != null
								&& this.getBfsfilehash().equals(castOther.getBfsfilehash())))
				&& ((this.getStatus() == castOther.getStatus()) || (this.getStatus() != null
						&& castOther.getStatus() != null && this.getStatus().equals(castOther.getStatus())))
				&& ((this.getServiceloc() == castOther.getServiceloc()) || (this.getServiceloc() != null
						&& castOther.getServiceloc() != null && this.getServiceloc().equals(castOther.getServiceloc())))
				&& ((this.getFilesize() == castOther.getFilesize()) || (this.getFilesize() != null
						&& castOther.getFilesize() != null && this.getFilesize().equals(castOther.getFilesize())))
				&& ((this.getFiletype() == castOther.getFiletype()) || (this.getFiletype() != null
						&& castOther.getFiletype() != null && this.getFiletype().equals(castOther.getFiletype())))
				&& ((this.getBfsorgauthfilename() == castOther.getBfsorgauthfilename())
						|| (this.getBfsorgauthfilename() != null && castOther.getBfsorgauthfilename() != null
								&& this.getBfsorgauthfilename().equals(castOther.getBfsorgauthfilename())))
				&& ((this.getAuthorizeby() == castOther.getAuthorizeby())
						|| (this.getAuthorizeby() != null && castOther.getAuthorizeby() != null
								&& this.getAuthorizeby().equals(castOther.getAuthorizeby())))
				&& ((this.getAuthorizedate() == castOther.getAuthorizedate())
						|| (this.getAuthorizedate() != null && castOther.getAuthorizedate() != null
								&& this.getAuthorizedate().equals(castOther.getAuthorizedate())))
				&& ((this.getTransactionno() == castOther.getTransactionno())
						|| (this.getTransactionno() != null && castOther.getTransactionno() != null
								&& this.getTransactionno().equals(castOther.getTransactionno())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBfsfilereferenceno() == null ? 0 : this.getBfsfilereferenceno().hashCode());
		result = 37 * result + (getBfsgroupid() == null ? 0 : this.getBfsgroupid().hashCode());
		result = 37 * result + (getBfsfiletype() == null ? 0 : this.getBfsfiletype().hashCode());
		result = 37 * result + (getBfsdescription() == null ? 0 : this.getBfsdescription().hashCode());
		result = 37 * result + (getCreatedby() == null ? 0 : this.getCreatedby().hashCode());
		result = 37 * result + (getCreateddate() == null ? 0 : this.getCreateddate().hashCode());
		result = 37 * result + (getModifiedby() == null ? 0 : this.getModifiedby().hashCode());
		result = 37 * result + (getModifieddate() == null ? 0 : this.getModifieddate().hashCode());
		result = 37 * result + (getVersionnum() == null ? 0 : this.getVersionnum().hashCode());
		result = 37 * result + (getBfsorgfilename() == null ? 0 : this.getBfsorgfilename().hashCode());
		result = 37 * result + (getBfsfilehash() == null ? 0 : this.getBfsfilehash().hashCode());
		result = 37 * result + (getStatus() == null ? 0 : this.getStatus().hashCode());
		result = 37 * result + (getServiceloc() == null ? 0 : this.getServiceloc().hashCode());
		result = 37 * result + (getFilesize() == null ? 0 : this.getFilesize().hashCode());
		result = 37 * result + (getFiletype() == null ? 0 : this.getFiletype().hashCode());
		result = 37 * result + (getBfsorgauthfilename() == null ? 0 : this.getBfsorgauthfilename().hashCode());
		result = 37 * result + (getAuthorizeby() == null ? 0 : this.getAuthorizeby().hashCode());
		result = 37 * result + (getAuthorizedate() == null ? 0 : this.getAuthorizedate().hashCode());
		result = 37 * result + (getTransactionno() == null ? 0 : this.getTransactionno().hashCode());
		return result;
	}

}