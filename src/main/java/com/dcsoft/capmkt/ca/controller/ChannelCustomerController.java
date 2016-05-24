package com.dcsoft.capmkt.ca.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcsoft.capmkt.bo.intf.IChannelCustomerService;
import com.dcsoft.capmkt.bo.transferobj.ChannelCustomerTO;
import com.dcsoft.capmkt.constants.Constants;
import com.dcsoft.capmkt.util.errors.CustomErrorHandler;

@Controller
public class ChannelCustomerController {
	
	@Autowired(required=true)
	private IChannelCustomerService chnlCustomerService;
	
	@RequestMapping(value="/customers" , method=RequestMethod.GET)
	public String gotoUserHome(Model model){
		model.addAttribute("listCustomers", chnlCustomerService.list());
		return "customers";
	}
	@RequestMapping(value="/createcustomer" , method=RequestMethod.GET)
	public String gotoCreateScreen(Model model){
		model.addAttribute("mode", Constants.MODE_CREATE);
		model.addAttribute("customer", new ChannelCustomerTO());
		return "createcustomer";
	}
	
	@RequestMapping(value="/createcustomer" , method=RequestMethod.POST)
	public String createChannelCustomer(@Valid ChannelCustomerTO customerTO , BindingResult result, Model model){
		model.addAttribute("mode", Constants.MODE_CREATE);
		model.addAttribute("customer",customerTO);
		
		if(result.hasErrors()){
			CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
			model.addAttribute("errors", handler.getCustomErrors());
			return "createcustomer";
		}
		
		/**
		 * Check for duplicate Channel Customer
		 */
		if(!chnlCustomerService.getCustomerByExample(customerTO).isEmpty()){
			
			FieldError fieldError = new FieldError("channelCustName", "", "Channel Customer : " + customerTO.getChannelCustName() + " already Exists");
			result.addError(fieldError);
	
			if (result.hasErrors()) {
				CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
				model.addAttribute("errors", handler.getCustomErrors());
				return "createcustomer";
			}
		}
		
		if(chnlCustomerService.addCustomer(customerTO)){
			model.addAttribute("success","Channel Customer : "+ customerTO.getChannelCustName() + " created successfully.");
		}else{
			//Show failure message
		}
		return "createcustomer";
	}
}
