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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcsoft.capmkt.bo.intf.IChannelUserService;
import com.dcsoft.capmkt.bo.intf.ICommonService;
import com.dcsoft.capmkt.bo.transferobj.ChUserTO;
import com.dcsoft.capmkt.util.errors.CustomErrorHandler;

@Controller
public class ChannelUserController {
	
	
	@Autowired(required=true)
	@Qualifier(value="chnlUserService")
	private IChannelUserService channelUserService;
	
	@Autowired(required=true)
	@Qualifier(value="commonService")
	private ICommonService commonService;
	
	@RequestMapping(value="/channeluser" , method=RequestMethod.GET)
	public String gotoUserHomeBlank(Model model){
		model.addAttribute("searchUser", new ChUserTO());
		model.addAttribute("userList", channelUserService.list());
		return "channeluser";
	}
	
	@RequestMapping(value="/channeluser" , method=RequestMethod.POST)
	public String gotoUserHome(ChUserTO userto,Model model){
		model.addAttribute("searchUser", userto);
		List<Serializable> returnList = channelUserService.getUserByExample(userto);
		model.addAttribute("userList", null);
		if(returnList==null){
			CustomErrorHandler.showNarrowCriteriaError(model);
		}
		else if(returnList.size()>0){
			model.addAttribute("userList", returnList);
		}else{
			CustomErrorHandler.showNoDataFoundMessage(model);
		}
		return "channeluser";
	}
	
	@RequestMapping(value="/channeluser/{id}/details" , method=RequestMethod.GET)
	public String getUserDetails(@PathVariable ("id") BigDecimal id,Model model){
		model.addAttribute("userDetails", channelUserService.getUserDetails(id));
		return "userDetails";
	}
	
	@RequestMapping(value="/channeluser/createUser" , method= RequestMethod.GET)
	public String opencreateUserScreen(Model model) {
		model.addAttribute("mode", "create");
		model.addAttribute("user", new ChUserTO());
		model.addAttribute("countries", commonService.getCountryCodes());
		model.addAttribute("states", commonService.getStates("us"));
		return "createUser";
	}
	
	@RequestMapping(value="/channeluser/createUser" , method= RequestMethod.POST)
	public String createUser(@Valid ChUserTO userTO, BindingResult result, Model model) {
		model.addAttribute("mode", "create");
		model.addAttribute("user", userTO);
		model.addAttribute("countries", commonService.getCountryCodes());
		model.addAttribute("states", commonService.getStates(userTO.getCountry().toUpperCase()));
		if(result.hasErrors()){
			CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
			model.addAttribute("errors", handler.getCustomErrors());
			return "createUser";
		}
		
		/*
		 * create the user record , once done show the success message, but first find duplicate user
		 */
		
		if(!channelUserService.getUserByLoginID(userTO.getLoginid()).isEmpty()){
			FieldError fieldError = new FieldError("loginid", "", "User with Login ID : " + userTO.getLoginid() + " already Exists");
			result.addError(fieldError);
	
			if (result.hasErrors()) {
				CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
				model.addAttribute("errors", handler.getCustomErrors());
				return "createUser";
			}
		}
		
		if(channelUserService.addUser(userTO)){
			model.addAttribute("success","User with Login ID  : "+ userTO.getLoginid() + " created successfully.");
		}
		return "createUser";
	}
	
	@RequestMapping(value="/channeluser/{id}/editUser")
	public String edituser(@PathVariable ("id") BigDecimal id, Model model){
		model.addAttribute("mode", "edit");
		return "createUser";
	}
	
	@RequestMapping(value="/channeluser/{id}/deleteUser" /*, method=RequestMethod.DELETE*/)
	public String deleteuser(@PathVariable ("id") BigDecimal id, Model model){
		//model.addAttribute("mode", "Delete User");
		channelUserService.removeUser(id);
		return "redirect:/channeluser";
	}
}
