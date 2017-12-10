package com.sachin.usercardmanagement.bo.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sachin.usercardmanagement.bean.Card;
import com.sachin.usercardmanagement.bean.Wallet;
import com.sachin.usercardmanagement.bo.WalletBO;
import com.sachin.usercardmanagement.dao.WalletRepository;
import com.sachin.usercardmanagement.entity.WalletEntity;

@Component
public class WalletBOImpl implements WalletBO{
	
	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Wallet findByUserId(String userId) {
		WalletEntity walletEntity = walletRepository.findByUserId(userId);
		Wallet wallet=null;
		if(null != walletEntity) {
			wallet = new Wallet();
			wallet.setWalletId(walletEntity.getWalletId());
			wallet.setEnabled(walletEntity.getEnabled());
			wallet.setUserId(walletEntity.getUserId());
			Type listType = new TypeToken<Set<Card>>() {}.getType();
			Set<Card> cards = modelMapper.map(walletEntity.getCardDetailsEntities(), listType);
			wallet.setCards(cards);
		}
		
		return wallet;
		
	}

	
}
