package com.sachin.usercardmanagement.bean;

import java.util.Set;

import com.sachin.usercardmanagement.entity.CardDetailsEntity;

public class Wallet {
	private Integer walletId;
	private String userId;
	private Short enabled;
	private Set<Card> cards;
	public Integer getWalletId() {
		return walletId;
	}
	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Short getEnabled() {
		return enabled;
	}
	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}
	public Set<Card> getCards() {
		return cards;
	}
	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}
	
	

}
