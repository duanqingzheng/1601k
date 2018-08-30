package com.bw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.base.service.LoginService;
import com.bw.base.util.ResultJSON;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultJSON login(String username,String password) {
		
		//1.调用业务方法，验证用户输入
		ResultJSON rs = loginService.login(username,password);
		
		return rs;
	}
}
