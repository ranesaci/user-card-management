package com.sachin.usercardmanagement.bo;

import com.sachin.usercardmanagement.bean.Wallet;

public interface WalletBO {
	
	Wallet findByUserId(String userId);

}
