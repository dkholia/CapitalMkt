package com.dcsoft.capmkt.bo.transferobj;

import java.util.Comparator;

public class DropDown extends Model  implements Comparator<DropDown>{

	private static final long serialVersionUID = 3967011223808561661L;
	private String id;
	private String value;
	
	public DropDown(String id, String value) {
		this.id=id;
		this.value=value;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public int compare(DropDown o1, DropDown o2) {
		
		return o1.getId().hashCode()-o2.getId().hashCode();
	}
}
