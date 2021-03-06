package com.dcsoft.capmkt.ca.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcsoft.capmkt.bo.intf.IChannelCustomerService;
import com.dcsoft.capmkt.bo.transferobj.ChannelCustomerTO;
import com.dcsoft.capmkt.constants.Constants;
import com.dcsoft.capmkt.orm.ChChannelCustomer;
import com.dcsoft.capmkt.util.errors.CustomErrorHandler;

@Controller
public class ChannelCustomerController {
	
	@Autowired(required=true)
	private IChannelCustomerService chnlCustomerService;
	
	@RequestMapping(value="/home/customers" , method=RequestMethod.GET)
	public String gotoUserHomeBlank(Model model){
		model.addAttribute("searchCustomer", new ChannelCustomerTO());
		model.addAttribute("listCustomers", null);
		return "customers";
	}
	
	@RequestMapping(value="/home/customers" , method=RequestMethod.POST)
	public String gotoUserHome(ChannelCustomerTO customerTO, Model model){
		model.addAttribute("searchCustomer", customerTO);
		List<Serializable> returnList = chnlCustomerService.getCustomersByCriteria(customerTO);
		CustomErrorHandler.showResults(returnList, model, "listCustomers");
		return "customers";
	}
	@RequestMapping(value="/home/createcustomer" , method=RequestMethod.GET)
	public String gotoCreateScreen(Model model){
		model.addAttribute("mode", Constants.MODE_CREATE);
		model.addAttribute("customer", new ChannelCustomerTO());
		return "createcustomer";
	}
	
	@RequestMapping(value="/home/createcustomer" , method=RequestMethod.POST)
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
		ChChannelCustomer customer = (ChChannelCustomer) chnlCustomerService.findByExample(ChChannelCustomer.class, customerTO).get(0);
		customerTO.setChannelCustId(customer.getChannelCustId());
		//chnlCustomerService.saveObjectHash(ChChannelCustomer.class.getSimpleName(), customer.getChannelCustId().toPlainString(), customerTO.hashCode()+"");
		
		return "createcustomer";
	}
	
	@RequestMapping(value="/home/customers/customerdetails/{id}" , method=RequestMethod.GET)
	public String getCustomerDetails(@PathVariable("id") BigDecimal id , Model model ) {
		model.addAttribute("custdetails", chnlCustomerService.getCustomerDetails(id));
		return "customerdetails";
	}
}
