package com.sachin.usercardmanagement.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPassTest {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("admin"));
		System.out.println(bCryptPasswordEncoder.encode("sachin"));
		
	}

}
