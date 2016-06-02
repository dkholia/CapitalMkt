package com.dcsoft.capmkt.bo.transferobj;

import java.io.Serializable;

public class Model implements Serializable {

	private static final long serialVersionUID = 4573325926439062716L;
	protected Integer uniqueSequenceNumber;
	
	public Integer getUniqueSequenceNumber() {
		return uniqueSequenceNumber;
	}
	public void setUniqueSequenceNumber(Integer uniqueSequenceNumber) {
		this.uniqueSequenceNumber = uniqueSequenceNumber;
	}
}
