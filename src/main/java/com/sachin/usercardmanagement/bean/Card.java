package com.sachin.usercardmanagement.bean;

import javax.persistence.Column;

public class Card {

	private Integer id;
	private Integer cardId;
	private String type;
	private Integer walletId;
	private String email;
	private Integer cvv;
	private String address;
	private String phone;
	private Short enabled;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getWalletId() {
		return walletId;
	}
	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCvv() {
		return cvv;
	}
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Short getEnabled() {
		return enabled;
	}
	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}
	
	
}
