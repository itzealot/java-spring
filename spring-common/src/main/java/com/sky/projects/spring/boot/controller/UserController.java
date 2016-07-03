package com.sky.projects.spring.boot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sky.projects.spring.entity.User;
import com.sky.projects.spring.spi.UserService;

@EnableAutoConfiguration
@RestController
@RequestMapping("/spring-ws-web")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 注解 @RequestMapping 修饰方法，指明REST Full 的url
	 * 
	 * 注解 @PathVariable 指明需要注入的值
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/userServices/{id}")
	@ResponseBody
	public User view(@PathVariable("id") Long id) {
		return userService.get(id);
	}

	@RequestMapping("/userServices")
	@ResponseBody
	public Collection<User> getAll() {
		return userService.getAll();
	}

}
