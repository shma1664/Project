package com.shma.chapter02.login.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shma.chapter02.login.domain.User;
import com.shma.chapter02.login.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index.html")
	public String loginPage() {
		return "login";
	}
	
	/**
	 * 登录验证
	 * @param request
	 * @param response
	 * @param loginCommand
	 * @return
	 */
	@RequestMapping(value="/loginCheck.html", method = RequestMethod.POST)
	public ModelAndView loginCheck(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, LoginCommand loginCommand) {
		
		String userName = loginCommand.getUserName();
		String password = loginCommand.getPassword();
		
		boolean pattern = userService.hasMatchUser(userName, password);
		if(pattern) {
			User user = userService.findUserByUserName(userName);
			user.setCredits(user.getCredits() + 5);
			userService.loginSuccess(user.getUserId(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), request.getLocalAddr(), user.getCredits());
			
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
			
		} else {
			return new ModelAndView("login", "error", "用户名或密码错误");
		}
		
	}
}
