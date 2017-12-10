package com.sachin.usercardmanagement.bo.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.sachin.usercardmanagement.bean.User;
import com.sachin.usercardmanagement.bo.UserBO;
import com.sachin.usercardmanagement.dao.UserInfoDAO;
import com.sachin.usercardmanagement.entity.UserInfo;


@Component
public class UserBOImpl implements UserBO {
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserInfo save(User user) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(user.getUserId());
		userInfo.setFirstName(user.getFirstName());
		userInfo.setLastName(user.getLastName());
		userInfo.setRole(user.getRole());
		userInfo.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userInfo.setEnabled(user.getEnabled());
		
		return userInfoDAO.save(userInfo);
	}

	@Override
	public List<User> getAllUsers() {
		List<UserInfo> userInfos = userInfoDAO.getAllUsers();
		Type listType = new TypeToken<List<User>>() {}.getType();
		return modelMapper.map(userInfos, listType);
	}

	@Override
	public User findByUserId(String username) {
		UserInfo userInfo = userInfoDAO.findByUserId(username);
		return modelMapper.map(userInfo, User.class);
	}

}
