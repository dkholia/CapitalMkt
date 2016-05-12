package com.dcsoft.capmkt.orm;
// Generated Apr 7, 2016 1:42:57 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Reorder generated by hbm2java
 */
@Entity
@Table(name = "reorder", schema = "public")
public class Reorder implements java.io.Serializable {

	private ReorderId id;

	public Reorder() {
	}

	public Reorder(ReorderId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "reordercols", column = @Column(name = "reordercols", length = 400)),
			@AttributeOverride(name = "userid", column = @Column(name = "userid", length = 101)),
			@AttributeOverride(name = "tablename", column = @Column(name = "tablename", length = 50)),
			@AttributeOverride(name = "screenname", column = @Column(name = "screenname", length = 50)),
			@AttributeOverride(name = "state", column = @Column(name = "state", length = 50)) })
	public ReorderId getId() {
		return this.id;
	}

	public void setId(ReorderId id) {
		this.id = id;
	}

}