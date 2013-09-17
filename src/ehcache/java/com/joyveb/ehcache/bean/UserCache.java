package com.joyveb.ehcache.bean;

import org.springframework.stereotype.Component;

@Component("userCache")
public class UserCache extends AbstractEhcache<User> {

	public UserCache() {
		super("USER_CACHE");
	}


}
