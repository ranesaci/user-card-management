package com.sachin.usercardmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sachin.usercardmanagement.bean.User;
import com.sachin.usercardmanagement.bean.Wallet;
import com.sachin.usercardmanagement.bo.UserBO;
import com.sachin.usercardmanagement.bo.WalletBO;

@RestController
@RequestMapping("/user")
public class UserInfoController {
	
	private static final Logger logger = Logger.getLogger(UserInfoController.class);
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private WalletBO walletBO;
	
	@GetMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		//modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@GetMapping(value = "/register")
	public ModelAndView registerUserView() {
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}
	
	@PostMapping(value = "/register")
	public ModelAndView registerUser(@Valid User user, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			logger.info("Validation errors while submitting form.");
			modelAndView.setViewName("register");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		userBO.save(user);
		modelAndView.setViewName("login");
		logger.info("Form submitted successfully.");
		return modelAndView;
		
	
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = {"/secure/admin"}, method = RequestMethod.GET)
    public ModelAndView getUserList(Model model) {
		ModelAndView modelAndView = new ModelAndView("user-list");
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(null != user) {
			List<User> users = userBO.getAllUsers();
			modelAndView.addObject("userList", users);
		}
		
		return modelAndView;
    }
	@PreAuthorize("hasAnyRole('USER')")
	@RequestMapping(value = {"/secure/user"}, method = RequestMethod.GET)
    public ModelAndView getUserDetails(Model model) {
		ModelAndView modelAndView = new ModelAndView("user-details");
		org.springframework.security.core.userdetails.User contextUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(null != contextUser) {
			User user = userBO.findByUserId(contextUser.getUsername());
			Wallet wallet = walletBO.findByUserId(contextUser.getUsername());
			modelAndView.addObject("user", user);
			modelAndView.addObject("wallet", wallet);
		}
			
		return modelAndView;
    }

}
