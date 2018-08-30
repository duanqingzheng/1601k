package com.bw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.base.service.RegistService;
import com.bw.base.util.ResultJSON;


@Controller
public class RegistController {

	@Autowired
	private RegistService registService;
	
	@RequestMapping("/checkUsername")
	@ResponseBody
	public ResultJSON checkUsername(String username){
		ResultJSON rs=registService.checkUsername(username);
		return rs;
	}
	
	
	/***
	 * 注册
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/register")
	@ResponseBody
	public ResultJSON register(String username,String password) {
		
		
		//1.调用service，保存用户名和密码
		ResultJSON rs = registService.register(username,password);
		
		//2.返回成功注册信息
		
		return rs;
		
	}
	
	
}
