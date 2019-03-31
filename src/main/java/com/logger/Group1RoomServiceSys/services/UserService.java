package com.logger.Group1RoomServiceSys.services;

import java.util.List;

import com.logger.Group1RoomServiceSys.beans.User;
import com.logger.Group1RoomServiceSys.http.Response;

public interface UserService {

	public User getByName(String name);
	
	public List<User> getAll();
	
	public Response save(User user);
	
	public Response deleteById(int id);
	
	public Response changePassword(User user);
}
