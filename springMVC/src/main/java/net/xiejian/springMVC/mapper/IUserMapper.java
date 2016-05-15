package net.xiejian.springMVC.mapper;

import org.springframework.stereotype.Component;

import net.xiejian.springMVC.domain.User;

/**
 * 
 * @author jian_xie
 * @date 2016年5月14日
 */
@Component("userMapper")
public interface IUserMapper {
	
	/**
	 * 根据名称获得对象
	 * @param name
	 * @return
	 */
	public User getUserByName(String name);
	
	
}
