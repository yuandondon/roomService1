package com.logger.Group1RoomServiceSys.services;

import java.util.List;

import com.logger.Group1RoomServiceSys.beans.RoomService;
import com.logger.Group1RoomServiceSys.http.Response;

public interface RoomServiceService {
	
	public Response deleteById(int id);

	public List<RoomService> getAll();
	
	public Response save(RoomService roomService);

	public Response checkOut(RoomService roomService);
}
