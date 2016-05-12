package com.dcsoft.capmkt.ca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcsoft.capmkt.bo.intf.IChannelCustomerService;

@Controller
public class ChannelCustomerController {
	
	@Autowired(required=true)
	private IChannelCustomerService chnlCustomerService;
	
	@RequestMapping(value="/customers" , method=RequestMethod.GET)
	public String gotoUserHome(Model model){
		model.addAttribute("listCustomers", chnlCustomerService.list());
		return "customers";
	}

}
