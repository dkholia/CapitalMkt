package com.dcsoft.capmkt.bo.transferobj;

import java.io.Serializable;
import java.util.Comparator;

import javax.xml.bind.annotation.XmlRootElement;

import com.dcsoft.capmkt.ajax.Views;
import com.fasterxml.jackson.annotation.JsonView;

@XmlRootElement
public class DropDown  implements Serializable,Comparator<DropDown>{

	private static final long serialVersionUID = 3967011223808561661L;
	@JsonView(Views.Public.class)
	private String id;
	@JsonView(Views.Public.class)
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
