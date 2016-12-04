package com.dcsoft.capmkt.ajax;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	String msg;

	@JsonView(Views.Public.class)
	String code;

	@JsonView(Views.Public.class)
	List<Serializable> result;

	public String getMsg() {
		return msg;
	}

	public String getCode() {
		return code;
	}

	public List<Serializable> getResult() {
		return result;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setResult(List<Serializable> result) {
		this.result = result;
	}
}