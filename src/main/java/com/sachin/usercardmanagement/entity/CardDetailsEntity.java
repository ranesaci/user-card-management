package com.sachin.usercardmanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="card_details")
public class CardDetailsEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@Column(name="card_id")
	private Integer cardId;
	@Column(name="type")
	private String type;
	@Column(name="wallet_id")
	private Integer walletId;
	@Column(name="email")
	private String email;
	@Column(name="cvv")
	private Integer cvv;
	@Column(name="address")
	private String address;
	@Column(name="phone")
	private String phone;
	@Column(name="enabled")
	private Short enabled;
	
	@ManyToOne
    @JoinColumn(name="wallet_id",insertable=false, updatable=false)
	private WalletEntity walletEntity;

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

	public WalletEntity getWalletEntity() {
		return walletEntity;
	}

	public void setWalletEntity(WalletEntity walletEntity) {
		this.walletEntity = walletEntity;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	
	

}
