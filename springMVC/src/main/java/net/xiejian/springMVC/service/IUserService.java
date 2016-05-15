package net.xiejian.springMVC.service;

import net.xiejian.springMVC.domain.User;

public interface IUserService {

	/**
	 * 根据名称获得对象
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
}
