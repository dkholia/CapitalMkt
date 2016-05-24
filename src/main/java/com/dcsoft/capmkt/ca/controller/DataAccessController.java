package com.dcsoft.capmkt.ca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcsoft.capmkt.bo.intf.IDapService;
import com.dcsoft.capmkt.bo.transferobj.ChDapTO;
import com.dcsoft.capmkt.constants.Constants;

@Controller
public class DataAccessController {

	@Autowired(required=true)
	@Qualifier(value="chnlDapService")
	private IDapService chnlDapService;
	
	@RequestMapping(value="/dap" , method=RequestMethod.GET)
	public String gotoUserHome(Model model){
		model.addAttribute("dap", new ChDapTO());
		return "dap";
	}
	
	@RequestMapping(value="/createdap" , method=RequestMethod.GET)
	public String gotocreatedap(Model model){
		model.addAttribute("mode", Constants.MODE_CREATE);
		model.addAttribute("dap", new ChDapTO());
		model.addAttribute("customers", chnlDapService.getChannelCustomersDropDown());
		return "createdap";
	}
}
