package com.dcsoft.capmkt.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ControllerAdvice
public class AdviceController {

	@ExceptionHandler(Exception.class)
	public String handle(Exception ex) {
		return "redirect:/500";
	}

	@RequestMapping(value = {"/404"}, method = RequestMethod.GET)
	public String NotFoudPage() {
		return "404";

	}
}