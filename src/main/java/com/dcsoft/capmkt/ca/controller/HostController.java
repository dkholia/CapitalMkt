package com.dcsoft.capmkt.ca.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dcsoft.capmkt.bo.intf.IHostService;
import com.dcsoft.capmkt.bo.transferobj.ChHostTO;
import com.dcsoft.capmkt.orm.ChHost;
import com.dcsoft.capmkt.util.errors.CustomErrorHandler;

@Controller
@SessionAttributes("chhostTO")
public class HostController {

	private IHostService hostService;
	
	@ModelAttribute("chhostTO")
	public ChHostTO createFormBean() {
		return new ChHostTO();
	}
	
	@Autowired(required=true)
	@Qualifier(value="hostService")
	public void setHostService(IHostService hostService) {
		this.hostService = hostService;
	}
	
	
	
	@RequestMapping(value = "/host", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("host", new ChHost());
		model.addAttribute("listHost", this.hostService.listHosts());
		return "host";
	}
	
	@RequestMapping(value= "/host/add", method = RequestMethod.POST)
	public String addHost(@Valid ChHostTO chhostTO,BindingResult result,Model model){
		
		if (result.hasErrors()) {
			//return "redirect:/hosts";
			model.addAttribute("listHost", this.hostService.listHosts());
			CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
			model.addAttribute("errors", handler.getCustomErrors());
			return "host";
		}
		if(chhostTO.getHostId()== null){
			
			this.hostService.addHost(chhostTO);
		}else{
			//existing person, call update
			this.hostService.updateHost(chhostTO);
		}
		return "redirect:/host";
	}
	@RequestMapping("/host/remove/{id}"  )
    public String removeHost(@PathVariable("id") BigDecimal id){
		
        this.hostService.removeHost(id);
        return "redirect:/host";
    }
 
    @RequestMapping("/host/edit/{id}")
    public String editPerson(@PathVariable("id") BigDecimal id, Model model){
        model.addAttribute("host", this.hostService.getHostById(id));
    	model.addAttribute("listHost", this.hostService.listHosts());
        return "host";
    }
}
