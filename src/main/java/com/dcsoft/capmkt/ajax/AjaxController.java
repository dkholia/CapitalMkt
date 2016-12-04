package com.dcsoft.capmkt.ajax;
import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dcsoft.capmkt.bo.intf.IChannelUserService;
import com.dcsoft.capmkt.bo.intf.ICommonService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class AjaxController {

	@Autowired(required=true)
	@Qualifier(value="commonService")
	private ICommonService commonService;
	
	@Autowired(required=true)
	@Qualifier(value="chnlUserService")
	private IChannelUserService channelUserService;
	
	@JsonView(Views.Public.class)
	@RequestMapping(value = "/states" ,produces="application/json")
	public AjaxResponseBody getStates(@RequestParam String countryCode) {
		AjaxResponseBody result = new AjaxResponseBody();
		List<Serializable> states = findStates(countryCode);
		if (states.size() > 0) {
			result.setCode("200");
			result.setMsg("");
			result.setResult(states);
		} else {
			result.setCode("204");
			result.setMsg("No State found!");
		}
		return result;
	}

	private List<Serializable> findStates(String countryCode) {
		return commonService.getStates(countryCode);
	}
	
	//public AjaxResponseBody deleteUser()
}