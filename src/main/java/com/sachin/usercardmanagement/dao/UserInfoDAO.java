package com.sachin.usercardmanagement.dao;

import java.util.List;

import com.sachin.usercardmanagement.entity.UserInfo;

public interface UserInfoDAO {
	public abstract UserInfo getActiveUser(String userName);

	public abstract UserInfo save(UserInfo userInfo);

	public abstract List<UserInfo> getAllUsers();

	public abstract UserInfo findByUserId(String username);
}
