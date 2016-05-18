package net.xiejian.springMVC.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.xiejian.springMVC.dao.IUserDao;
import net.xiejian.springMVC.domain.User;
import net.xiejian.springMVC.mapper.IUserMapper;
import net.xiejian.springMVC.service.IUserService;

@Service("userService")
public class UserService implements IUserService{

	@Autowired
	@Qualifier("userMapper")
	private IUserMapper				userMapper;
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao				userDao;
	
	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}

}
