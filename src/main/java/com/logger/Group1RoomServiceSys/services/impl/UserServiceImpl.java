package com.logger.Group1RoomServiceSys.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logger.Group1RoomServiceSys.beans.User;
import com.logger.Group1RoomServiceSys.daos.UserDao;
import com.logger.Group1RoomServiceSys.http.Response;
import com.logger.Group1RoomServiceSys.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
//	@Autowired
//	private PasswordView passwordEncoder;

	@Override
	public User getByName(String name) {
		return userDao.findByName(name);
	}

	@Override
	public List<User> getAll() {
		
		return userDao.findAll();
	}

	@Override
	public Response save(User user) {
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		User u = userDao.findByName(user.getName());
		if(u == null) {
			userDao.save(user);
		}else {
			return new Response(false, "User name already on file.");
		}
		//System.out.println(u);
		
		return new Response(true, "register user success.");
	}

	@Override
	public Response deleteById(int id) {
		if(userDao.findById(id).get() != null) {
			userDao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "User is not found!");
		}
	}

	@Override
	public Response changePassword(User user) {
		//if(user.getName().equals(authentication.getName()) || isAdmin(authentication.getAuthorities())) {
		User u = userDao.findByName(user.getName());
		if(u != null) {
			
			//u.setPassword(passwordEncoder.encode(user.getPassword()));
			u.setPassword(user.getPassword());
			userDao.save(u);
		}else {
			//TODO: Not authorize to update password if not current loggedin user or admin.
			return new Response(false);
		}
		return new Response(true);
		
	}

}
