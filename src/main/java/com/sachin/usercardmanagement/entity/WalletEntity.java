package com.sachin.usercardmanagement.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="wallet_details")
public class WalletEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="wallet_id")
	private Integer walletId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="enabled")
	private Short enabled;
	
	@OneToMany(mappedBy="walletEntity")
	private Set<CardDetailsEntity> cardDetailsEntities;

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

	public Set<CardDetailsEntity> getCardDetailsEntities() {
		return cardDetailsEntities;
	}

	public void setCardDetailsEntities(Set<CardDetailsEntity> cardDetailsEntities) {
		this.cardDetailsEntities = cardDetailsEntities;
	}
	
	
	

}
