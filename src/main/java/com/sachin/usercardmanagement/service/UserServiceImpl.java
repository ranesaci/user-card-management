package com.sachin.usercardmanagement.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sachin.usercardmanagement.dao.UserInfoDAO;
import com.sachin.usercardmanagement.entity.UserInfo;



@Service
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserInfo userInfo = userInfoDAO.getActiveUser(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+userInfo.getRole());
		
		User user = new User(userInfo.getUserId(),userInfo.getPassword(),Arrays.asList(authority));
		
		UserDetails userDetails = (UserDetails)user; 
		return userDetails;
		
	}

}
