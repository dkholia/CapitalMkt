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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dcsoft.capmkt.bo.intf.IChannelCustomerGrpMapping;
import com.dcsoft.capmkt.bo.intf.IChannelCustomerService;
import com.dcsoft.capmkt.bo.intf.IGroupService;
import com.dcsoft.capmkt.bo.transferobj.ChGroupTO;
import com.dcsoft.capmkt.bo.transferobj.ChUserTO;
import com.dcsoft.capmkt.bo.transferobj.ChannelCustomerTO;
import com.dcsoft.capmkt.orm.ChChannelCustomer;
import com.dcsoft.capmkt.orm.ChGroup;
import com.dcsoft.capmkt.orm.dao.manager.GroupManager;
import com.dcsoft.capmkt.util.errors.CustomError;
import com.dcsoft.capmkt.util.errors.CustomErrorHandler;

@Controller
@SessionAttributes("group")
public class GroupController {

	private IGroupService groupService;
	private IChannelCustomerGrpMapping  chnlCustGrpMapService;
	private IChannelCustomerService chnlCustomerService;


	@ModelAttribute("group")
	public ChGroupTO createFormBean() {
		return new ChGroupTO();
	}

	@Autowired(required=true)
	@Qualifier(value="groupService")
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	@Autowired(required=true)
	@Qualifier(value="chnlCustGrpMapService")
	public void setChnlCustGrpMapService(IChannelCustomerGrpMapping chnlCustGrpMapService) {
		this.chnlCustGrpMapService = chnlCustGrpMapService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="chnlCustomerService")
	public void setChnlCustomerService(IChannelCustomerService chnlCustomerService) {
		this.chnlCustomerService = chnlCustomerService;
	}

	@RequestMapping(value="/group" , method=RequestMethod.GET)
	public String gotoUserHomeBlank(Model model){
		model.addAttribute("searchGroup", new ChGroupTO());
		model.addAttribute("listGroups", null);
		return "group";
	}
	
	@RequestMapping(value = "/group", method = RequestMethod.POST)
	private String listGroups(ChGroupTO chGroupTO, Model model) {
		//get all the groups 
		model.addAttribute("searchGroup", chGroupTO);
		List<Serializable> returnList = groupService.getGroupByCriteria(chGroupTO);
		model.addAttribute("listGroups", null);
		if(returnList==null){
			CustomErrorHandler.showNarrowCriteriaError(model);
		}
		else if(returnList.size()>0){
			model.addAttribute("listGroups", returnList);
		}else{
			CustomErrorHandler.showNoDataFoundMessage(model);
		}
		return "group";
	}
	
	
	@RequestMapping(value= "/group/add", method = RequestMethod.POST)
	public String addGroup(@Valid ChGroupTO chGroupTO,BindingResult result,Model model){

		if (result.hasErrors()) {
			model.addAttribute("listGroups", this.groupService.listGroups());
			CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());

			model.addAttribute("errors", handler.getCustomErrors());
			return "group";
		}
		if(chGroupTO.getGroupId()== null){

			this.groupService.addGroup(chGroupTO);
		}else{
			this.groupService.updateGroup(chGroupTO);
		}
		return "redirect:/group";
	}
	@RequestMapping("/group/remove/{id}"  )
	public String removeGroup(@PathVariable("id") BigDecimal id, Model model){
		List<Serializable> returnList = groupService.getGroupByCriteria(new ChGroupTO());
		model.addAttribute("listGroups", returnList);
		this.groupService.removeGroup(id);
		return "redirect:/group";
	}

	@RequestMapping("/group/createeditgroup/{id}")
	public String getGroup(@PathVariable("id") BigDecimal id, Model model){
		model.addAttribute("group", new GroupManager().convertToChGroupTOFromChgroup(groupService.getGroupById(id)));
		ChGroup group = groupService.getGroupDetails(id);
		List<ChannelCustomerTO> list = new GroupManager().getAllChannelCustomers(chnlCustomerService.list(), group.getChChannelCustGrpMappings());
		model.addAttribute("allCustomers", list);
		model.addAttribute("mode", "edit");
		return "createeditgroup";
	}
	
	@RequestMapping(value="/group/createeditgroup/{id}" , method=RequestMethod.POST)
	public String editGroup(@PathVariable("id") BigDecimal id,@Valid ChGroupTO chGroupTO, BindingResult result, Model model){
		model.addAttribute("group", chGroupTO);
		if (result.hasErrors()) {
			CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
			model.addAttribute("errors", handler.getCustomErrors());
			return "createeditgroup";
		}
		model.addAttribute("mode", "edit");
		groupService.updateGroup(chGroupTO);
		model.addAttribute("success", "Group : "+ chGroupTO.getGroupName() + " Edited successfully");
		return "createeditgroup";
	}
	
	@RequestMapping(value="/group/{id}/detail", method = RequestMethod.GET)
	public String groupDetails(@PathVariable("id") BigDecimal id, Model model){
		ChGroup group = groupService.getGroupDetails(id);
		model.addAttribute("groupdetails", group);
		return "groupdetails";	
	}
	@RequestMapping(value="/group/createeditgroup", method = RequestMethod.GET)
	public String createEditGroup(Model model) {
		model.addAttribute("mode", "create");
		model.addAttribute("group", new ChGroupTO());
		return "createeditgroup";
	}

	@RequestMapping(value="/group/createeditgroup", method = RequestMethod.POST)
	public String createGroup(@Valid ChGroupTO chGroupTO,BindingResult result,Model model) {
		model.addAttribute("mode", "create");
		model.addAttribute("group", chGroupTO);
		
		
		if (result.hasErrors()) {
			CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
			model.addAttribute("errors", handler.getCustomErrors());
			return "createeditgroup";
		}
		/* 
		 Find out if a duplicate group exists
		 */
		
		if(this.groupService.findByExample(ChGroup.class, chGroupTO).size()>0){
			FieldError fieldError = new FieldError("grpname", "", "Group " + chGroupTO.getGroupName() + " already Exists");
			result.addError(fieldError);
	
			if (result.hasErrors()) {
				CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
				model.addAttribute("errors", handler.getCustomErrors());
				return "createeditgroup";
			}
		}
		if(chGroupTO.getGroupId()== null){
			this.groupService.addGroup(chGroupTO);
			model.addAttribute("success","Group : "+ chGroupTO.getGroupName()+ " created successfully.");
		}else{
			this.groupService.updateGroup(chGroupTO);
		}
		return "createeditgroup";
	}
}
