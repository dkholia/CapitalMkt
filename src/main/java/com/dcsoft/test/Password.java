package com.dcsoft.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {
	public static void main(String[] args) {
		BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
		System.out.println(enc.encode("deep"));
	}
}
