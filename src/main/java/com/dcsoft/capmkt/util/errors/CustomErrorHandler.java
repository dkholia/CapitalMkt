package com.dcsoft.capmkt.util.errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;


public class CustomErrorHandler {
	
	List<ObjectError> errors = null;
	String error = null;

	public CustomErrorHandler(List<ObjectError> errors) {
		this.errors= errors;
	}
	
	public CustomErrorHandler(String error) {
		this.error=error;
		
	}
	public List<CustomError> getCustomErrors() {
		List<CustomError> customErrors = new ArrayList<CustomError>();
		for(int i=0;i<errors.size();i++){
			CustomError err = new CustomError(((FieldError)errors.get(i)).getField(),errors.get(i).getDefaultMessage() );
			customErrors.add(err);
		}
		return customErrors;
	}
	
	public List<CustomError> getErrorFromString(){
		List<CustomError> customError = new ArrayList<CustomError>();
		CustomError err = new CustomError(null,error);
		customError.add(err);
		return customError;
	}
	
	public static void showNoDataFoundMessage(Model model){
		CustomErrorHandler handler = new CustomErrorHandler("No Data found for the search criteria");
		model.addAttribute("errors", handler.getErrorFromString() );
	}

	public static void showNarrowCriteriaError(Model model) {
		CustomErrorHandler handler = new CustomErrorHandler("Please enter atleast one field to narrow down the search");
		model.addAttribute("errors", handler.getErrorFromString() );
	}
}
