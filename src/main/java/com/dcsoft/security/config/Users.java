package com.dcsoft.security.config;
// Generated Nov 25, 2016 12:24:44 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", schema = "public")
public class Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3376189968213187357L;
	private String username;
	private String password;
	private Boolean enabled;
	private Set<UserRoles> userRoleses = new HashSet<UserRoles>(0);
	private Set<UserRoles> userRoleses_1 = new HashSet<UserRoles>(0);

	public Users() {
	}

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Users(String username, String password, Boolean enabled, Set<UserRoles> userRoleses,
			Set<UserRoles> userRoleses_1) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRoleses = userRoleses;
		this.userRoleses_1 = userRoleses_1;
	}

	@Id

	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled")
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<UserRoles> getUserRoleses() {
		return this.userRoleses;
	}

	public void setUserRoleses(Set<UserRoles> userRoleses) {
		this.userRoleses = userRoleses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_user_roles", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "userrole_user_role_id"), joinColumns = {
			@JoinColumn(name = "users_username", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "userrole_user_role_id", unique = true, nullable = false, updatable = false) })
	public Set<UserRoles> getUserRoleses_1() {
		return this.userRoleses_1;
	}

	public void setUserRoleses_1(Set<UserRoles> userRoleses_1) {
		this.userRoleses_1 = userRoleses_1;
	}

}
