package com.logger.Group1RoomServiceSys.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logger.Group1RoomServiceSys.beans.RoomService;

public interface RoomServiceDao extends JpaRepository<RoomService, Integer>{
	
}
