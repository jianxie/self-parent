package net.xiejian.springMVC.dao.impl;

import org.springframework.stereotype.Repository;

import net.xiejian.base.CommonDao;
import net.xiejian.springMVC.dao.IUserDao;
import net.xiejian.springMVC.domain.User;

@Repository("userDao")
public class UserDao extends CommonDao implements IUserDao {

	@Override
	public User getUserByName(String name) {
		return this.getSqlSession().selectOne("net.xiejian.springMVC.mapper.IUserMapper.getUserByName", name);
	}

}
