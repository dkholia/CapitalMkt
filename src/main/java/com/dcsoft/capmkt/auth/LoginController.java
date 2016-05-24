package com.dcsoft.capmkt.auth;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.dcsoft.capmkt.bo.intf.LoginService;
import com.dcsoft.capmkt.orm.ChUser;
import com.dcsoft.capmkt.orm.ChUserLogin;
import com.dcsoft.capmkt.util.errors.CustomErrorHandler;

@Controller
public class LoginController {
	
	private LoginService loginService;
	
	@Autowired
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String gotologinGet(Model model,HttpSession sessionObj){
		model.addAttribute("login", new ChUserLogin());
		return "";
	}
	
	@RequestMapping(value= "/", method = RequestMethod.POST)
	public String gotologin(Model model,HttpSession sessionObj){
		model.addAttribute("login", new ChUserLogin());
		sessionObj.setAttribute("status", "valid");
		return "";
	}

	@RequestMapping(value= "/login", method = RequestMethod.POST)
	public String login(@Valid ChUserLogin chUserLogin ,BindingResult result , Model model, @RequestParam("username") String username , @RequestParam("password") String password,HttpServletRequest request, HttpServletResponse response){
		
		/*chUserLogin.setUname(username);
		chUserLogin.setUpwd(password);
		model.addAttribute("login", chUserLogin);
		
		if(result.hasErrors()){
			CustomErrorHandler handler = new CustomErrorHandler(result.getAllErrors());
			model.addAttribute("errors", handler.getCustomErrors());
			return "redirect:/";
		}*/
		
		HttpSession session = request.getSession();
		
		ChUser user = new ChUser(username,password,true);
		if(loginService.findByExample(user).isEmpty())
			return "redirect:/";
		
		session.setAttribute("USER_TOKEN", user);
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString("en"));
		session.setAttribute("locale", new Locale("en", "US"));
		
		return "redirect:/home";
	}
}
