package com.sachin.usercardmanagement.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.usercardmanagement.bean.Wallet;
import com.sachin.usercardmanagement.bo.WalletBO;

@RestController
@RequestMapping("/wallet")
public class WalletController {
private static final Logger logger = Logger.getLogger(WalletController.class);
	
	@Autowired
	private WalletBO walletBO;
	
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@RequestMapping(value = "/secure/user/{userId}", method = RequestMethod.GET)
    public Wallet getWallet(@PathVariable(required = true) String userId) {
		Wallet wallet=walletBO.findByUserId(userId);
        return wallet;
    }

}
