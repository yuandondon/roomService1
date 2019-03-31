package com.logger.Group1RoomServiceSys.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.logger.Group1RoomServiceSys.beans.User;
import com.logger.Group1RoomServiceSys.daos.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		// Spring will call this function to load the user from DB
		User user = userDao.findByName(name);
		if(user == null) {
			throw new UsernameNotFoundException("User " + name + " was not found in the database");
		}
		return user;
	}

}
