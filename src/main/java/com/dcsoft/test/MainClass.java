package com.dcsoft.test;

import org.springframework.web.client.RestTemplate;

public class MainClass {

	public static void main(String[] args) {
		 final String uri = "http://localhost:18080/CapitalMkt/employees/Deep Chandra Kholia";
	     
		    RestTemplate restTemplate = new RestTemplate();
		    String result = restTemplate.getForObject(uri, String.class);
		     
		    System.out.println(result);
	}

}
