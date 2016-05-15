package net.xiejian.springMVC.domain;

/**
 * 成员
 * @author jian_xie
 * @date 2016年5月14日
 */
public class User {
	
	private String				userName;			// 名称
	
	private String 				userAge;			// 年龄
	
	private String				userAddress;		// 地址

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
}
