package com.logger.Group1RoomServiceSys.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logger.Group1RoomServiceSys.beans.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByName(String name);

}
