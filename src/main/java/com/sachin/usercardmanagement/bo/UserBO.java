package com.sachin.usercardmanagement.bo;

import java.util.List;

import com.sachin.usercardmanagement.bean.User;
import com.sachin.usercardmanagement.entity.UserInfo;

public interface UserBO {
	
	UserInfo save(User user);

	List<User> getAllUsers();

	User findByUserId(String username);

}
