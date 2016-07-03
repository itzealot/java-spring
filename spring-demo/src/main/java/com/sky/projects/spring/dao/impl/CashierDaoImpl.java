package com.sky.projects.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sky.projects.spring.dao.CashierDao;
import com.sky.projects.spring.service.BookService;

@Service("cashierDao")
public class CashierDaoImpl implements CashierDao {

	@Autowired
	private BookService bookService;

	// 声明事务，添加事务注解

	@Transactional
	public void checkout(String username, List<String> isbns) {
		for (String isbn : isbns) {
			bookService.purchase(username, isbn);
		}
	}

}
