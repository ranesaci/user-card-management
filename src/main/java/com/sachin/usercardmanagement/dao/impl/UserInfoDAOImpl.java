package com.sachin.usercardmanagement.dao.impl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sachin.usercardmanagement.bean.User;
import com.sachin.usercardmanagement.dao.UserInfoDAO;
import com.sachin.usercardmanagement.entity.UserInfo;




@Repository
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public UserInfo getActiveUser(String userName) {
		UserInfo userInfo = new UserInfo();
		short ENABLED = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE u.userId=? and enabled=?")
				.setParameter(1, userName).setParameter(2, ENABLED).getResultList();
		if (!list.isEmpty()) {
			userInfo = (UserInfo) list.get(0);
		}
		return userInfo;
	}

	@Override
	@Transactional
	public UserInfo save(UserInfo userInfo) {
		entityManager.persist(userInfo);
		return userInfo;
	}

	@Override
	public List<UserInfo> getAllUsers() {
		Query query = entityManager.createQuery("select u from UserInfo u");
	    return  query.getResultList();
	}

	@Override
	public UserInfo findByUserId(String username) {
		Query query = entityManager.createQuery("select u from UserInfo u where u.userId=?").setParameter(1, username);
	    return  (UserInfo) query.getSingleResult();
		
	}
	
	
}