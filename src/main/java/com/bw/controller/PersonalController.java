package com.bw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.base.domain.Logininfo;
import com.bw.base.service.AccountService;
import com.bw.base.service.UserInfoService;
import com.bw.base.util.UserContext;
import com.bw.business.domain.Account;
import com.bw.business.domain.Userinfo;


@Controller
public class PersonalController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/personal")
	public String toPersonal(Model model) {
		
		//1.拿logininfo放到Model 中
		Logininfo current = UserContext.getCurrent();
		//model.addAttribute("logininfo", current);
		Userinfo ui = userInfoService.findUserInfoById(current.getId());
		
		Account account = accountService.findAccountById(current.getId());
		model.addAttribute("userinfo", ui);
		model.addAttribute("account", account);
		return "personal";
	}
	
	
	
}
