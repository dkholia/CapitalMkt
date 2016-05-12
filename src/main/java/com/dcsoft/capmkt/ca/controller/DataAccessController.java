package com.dcsoft.capmkt.ca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataAccessController {

	@RequestMapping(value="/dap" , method=RequestMethod.GET)
	public String gotoUserHome(){
		return "dap";
	}

}
