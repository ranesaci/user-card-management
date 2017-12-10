package com.sachin.usercardmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sachin.usercardmanagement.entity.WalletEntity;

@Repository
public interface WalletRepository  extends JpaRepository<WalletEntity, Integer>{
	
	WalletEntity findByUserId(String userId);

}
