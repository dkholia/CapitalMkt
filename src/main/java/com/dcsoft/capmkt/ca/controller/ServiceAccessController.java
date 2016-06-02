package com.dcsoft.capmkt.ca.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcsoft.capmkt.bo.intf.IFapService;
import com.dcsoft.capmkt.bo.transferobj.ChFapTO;
import com.dcsoft.capmkt.util.errors.CustomErrorHandler;

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
		model.addAttribute("searchFap", new ChFapTO());
		model.addAttribute("fapList", null);
		return "fap";
	}
	
	@RequestMapping(value="/fap" , method=RequestMethod.POST)
	public String searchFap(ChFapTO chFapTO, Model model){
		model.addAttribute("searchFap", chFapTO);
		List<Serializable> list = chnlFapService.getFapByCriteria(chFapTO);
		if(list.isEmpty()){
			CustomErrorHandler.showNoDataFoundMessage(model);
			return "fap";
		}
		model.addAttribute("fapList", list);
		return "fap";
	}
}
