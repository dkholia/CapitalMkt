package com.dcsoft.capmkt.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dcsoft.capmkt.bo.intf.LoginService;
import com.dcsoft.capmkt.orm.ChUser;
import com.dcsoft.capmkt.util.errors.CustomErrorHandler;

@Controller
public class LoginController {
	
	private LoginService loginService;
	
	@Autowired
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username , @RequestParam("password") String password/*, HttpServletRequest request*/){
		/*if(result.hasErrors()){
			CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
			model.addAttribute("errors", handler.getCustomErrors());
			return "redirect:/";
		}*/
		ChUser user = new ChUser(username,password,true);
		if(loginService.findByExample(user).isEmpty())
			return "redirect:/";
		return "redirect:/home";
	}
}
