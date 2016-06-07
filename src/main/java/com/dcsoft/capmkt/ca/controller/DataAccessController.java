package com.dcsoft.capmkt.ca.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcsoft.capmkt.bo.intf.IDapService;
import com.dcsoft.capmkt.bo.transferobj.ChDapTO;
import com.dcsoft.capmkt.constants.Constants;
import com.dcsoft.capmkt.util.errors.CustomErrorHandler;

@Controller
public class DataAccessController  {

	private static final Logger logger = LoggerFactory.getLogger(DataAccessController.class);
	
	@Autowired(required=true)
	@Qualifier(value="chnlDapService")
	private IDapService chnlDapService;
	
	@RequestMapping(value="/dap" , method=RequestMethod.GET)
	public String gotoDapHome(Model model){
		model.addAttribute("seaarchDap", new ChDapTO());
		model.addAttribute("dapList", null);
		model.addAttribute("customers", chnlDapService.getChannelCustomersDropDown());
		return "dap";
	}
	
	@RequestMapping(value="/dap" , method=RequestMethod.POST)
	public String searchDap(ChDapTO dapTO,Model model){
		model.addAttribute("seaarchDap",dapTO);
		model.addAttribute("customers", chnlDapService.getChannelCustomersDropDown());
		
		List<Serializable> list = chnlDapService.getDapByCriteria(dapTO);
		if(list==null){
			CustomErrorHandler.showNarrowCriteriaError(model);
			return "dap";
		}
		if(list.isEmpty()){
			CustomErrorHandler.showNoDataFoundMessage(model);
			return "dap";
		}
		model.addAttribute("dapList", list);
		return "dap";
	}
	
	@RequestMapping(value="/createdap" , method=RequestMethod.GET)
	public String gotocreatedap(Model model){
		model.addAttribute("mode", Constants.MODE_CREATE);
		model.addAttribute("dap", new ChDapTO());
		model.addAttribute("customers", chnlDapService.getChannelCustomersDropDown());
		return "createdap";
	}
	
	@RequestMapping(value="/createdap" , method=RequestMethod.POST)
	public String createdap(@Valid ChDapTO chDapTO , BindingResult result,Model model){
		model.addAttribute("mode", Constants.MODE_CREATE);
		model.addAttribute("dap", chDapTO);
		model.addAttribute("customers", chnlDapService.getChannelCustomersDropDown());
		if(result.hasErrors()){
			CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
			model.addAttribute("errors", handler.getCustomErrors());
			return "createdap";
		}
		
		/*
		 * create the Data Access record , once done show the success message, but first find duplicate Data Access
		 */
		
		if(!chnlDapService.getDataAccessByName(chDapTO.getDapName()).isEmpty()){
			FieldError fieldError = new FieldError("dapName", "", "Data Access : " + chDapTO.getDapName() + " already Exists");
			result.addError(fieldError);
	
			if (result.hasErrors()) {
				CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
				model.addAttribute("errors", handler.getCustomErrors());
				return "createdap";
			}
		}
		chDapTO.setUniqueSequenceNumber(chDapTO.hashCode());
		if(chnlDapService.addDataAccess(chDapTO)){
			model.addAttribute("success","Data Access  : "+ chDapTO.getDapName() + " created successfully.");
		}
		return "createdap";
	}
	
	@RequestMapping(value="/dap/details/{id}" , method=RequestMethod.GET)
	public String dapDetails(@PathVariable("id") BigDecimal id, Model model){
		model.addAttribute("dapdetails", chnlDapService.getDataAccessDetails(id));
		return "dapdetails";
	}
}
