package com.dcsoft.capmkt.ca.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dcsoft.capmkt.bo.intf.IChannelUserService;

@Controller
public class ChannelUserController {
	
	@Autowired(required=true)
	@Qualifier(value="chnlUserService")
	private IChannelUserService channelUserService;
	
	@RequestMapping(value="/channeluser" , method=RequestMethod.GET)
	public String gotoUserHome(Model model){
		model.addAttribute("userList", channelUserService.list());
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
		return "createUser";
	}
	
	@RequestMapping(value="/channeluser/createUser" , method= RequestMethod.POST)
	public String createUser(Model model) {
		model.addAttribute("mode", "create");
		return "createUser";
	}
	
	@RequestMapping(value="/channeluser/{id}/editUser")
	public String edituser(@PathVariable ("id") BigDecimal id, Model model){
		model.addAttribute("mode", "edit");
		return "createUser";
	}
	
	@RequestMapping(value="/channeluser/deleteUser/{id}")
	public String deleteuser(@PathVariable ("id") BigDecimal id, Model model){
		model.addAttribute("mode", "Delete User");
		return "channeluser";
	}
}
