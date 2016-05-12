package com.dcsoft.capmkt.ca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcsoft.capmkt.bo.intf.IFapService;

@Controller
public class ServiceAccessController {
	
	
	private IFapService chnlFapService;
	
	public IFapService getChnlFapService() {
		return chnlFapService;
	}

	@Autowired(required=true)
	@Qualifier(value="chnlFapService")
	public void setChnlFapService(IFapService chnlFapService) {
		this.chnlFapService = chnlFapService;
	}

	@RequestMapping(value="/fap" , method=RequestMethod.GET)
	public String gotoFapHome(Model model){
		model.addAttribute("fapList", chnlFapService.list());
		return "fap";
	}

}
