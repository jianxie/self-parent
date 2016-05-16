package net.xiejian.springMVC.dao;

import net.xiejian.springMVC.domain.User;

public interface IUserDao {
	
	/**
	 * 根据名称获得对象
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
}
