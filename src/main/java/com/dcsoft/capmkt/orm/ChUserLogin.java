package com.dcsoft.capmkt.orm;
// Generated Apr 7, 2016 1:42:57 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ChUser generated by hbm2java
 */
@Entity
@Table(name = "ch_user", schema = "public")
public class ChUserLogin implements java.io.Serializable {

	private static final long serialVersionUID = 860386669462057901L;
	private String uname;
	private String upwd;

	public ChUserLogin() {
	}

	@Column(name = "uname", nullable = false, length = 100)
	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Column(name = "upwd", nullable = false, length = 100)
	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

}
