package com.dcsoft.capmkt.ca.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcsoft.capmkt.bo.intf.ICommonService;
import com.dcsoft.capmkt.bo.intf.IFapService;
import com.dcsoft.capmkt.bo.transferobj.ChFapTO;
import com.dcsoft.capmkt.orm.ChFap;
import com.dcsoft.capmkt.util.errors.CustomErrorHandler;

@Controller
public class ServiceAccessController {
	
	
	private IFapService chnlFapService;
	private ICommonService commonService;
	
	public ICommonService getCommonService() {
		return commonService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="commonService")
	public void setCommonService(ICommonService commonService) {
		this.commonService = commonService;
	}

	public IFapService getChnlFapService() {
		return chnlFapService;
	}

	@Autowired(required=true)
	@Qualifier(value="chnlFapService")
	public void setChnlFapService(IFapService chnlFapService) {
		this.chnlFapService = chnlFapService;
	}

	@RequestMapping(value="/home/fap" , method=RequestMethod.GET)
	public String gotoFapHome(Model model){
		model.addAttribute("searchFap", new ChFapTO());
		model.addAttribute("fapList", null);
		return "fap";
	}
	
	@RequestMapping(value="/home/fap" , method=RequestMethod.POST)
	public String searchFap(ChFapTO chFapTO, Model model){
		model.addAttribute("searchFap", chFapTO);
		List<Serializable> returnList = chnlFapService.getFapByCriteria(chFapTO);
		CustomErrorHandler.showResults(returnList, model, "fapList");
		return "fap";
	}
	
	@RequestMapping(value="/home/createfap" , method=RequestMethod.GET)
	public String gotocreateFap( Model model){
		model.addAttribute("mode", "create");
		model.addAttribute("fap", new ChFapTO());
		model.addAttribute("services", commonService.getServices());
		return "createfap";
	}
	
	@RequestMapping(value="/home/createfap" , method=RequestMethod.POST)
	public String createFap(@Valid ChFapTO fapTO, BindingResult result, Model model){
		model.addAttribute("mode", "create");
		model.addAttribute("fap",fapTO);
		model.addAttribute("services", commonService.getServices());
		if(result.hasErrors()){
			CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
			model.addAttribute("errors", handler.getCustomErrors());
			return "createfap";
		}
		
		if(!getChnlFapService().getFapByName(fapTO.getFapName()).isEmpty()){
			FieldError fieldError = new FieldError("loginid", "", "Service Access : " + fapTO.getFapName() + " already Exists");
			result.addError(fieldError);
	
			if (result.hasErrors()) {
				CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
				model.addAttribute("errors", handler.getCustomErrors());
				return "createfap";
			}
		}
		if(getChnlFapService().addServiceAccess(fapTO)){
			BigDecimal fapID = ((ChFap)getChnlFapService().getFapByCriteria(fapTO).get(0)).getFapId();
			try {
				getChnlFapService().attachServicesToFAP(fapID, fapTO.getLinkedServices());
				model.addAttribute("success","Service Access : "+ fapTO.getFapName() + " created successfully.");
			} catch (Exception e) {
				getChnlFapService().removeFap(fapID);
			}
		}
		return "createfap";
	}
	
	
	@RequestMapping(value="/home/fap/details/{id}" , method=RequestMethod.GET)
	public String fapDetails(@PathVariable("id") BigDecimal id, Model model){
		model.addAttribute("fapdetails", chnlFapService.getServiceAccessDetails(id));
		return "fapdetails";
	}
	
}
