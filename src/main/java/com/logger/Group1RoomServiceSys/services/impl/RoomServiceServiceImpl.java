package com.logger.Group1RoomServiceSys.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logger.Group1RoomServiceSys.beans.FoodOrder;
import com.logger.Group1RoomServiceSys.beans.RoomService;
import com.logger.Group1RoomServiceSys.http.Response;
import com.logger.Group1RoomServiceSys.services.RoomServiceService;
import com.logger.Group1RoomServiceSys.daos.RoomServiceDao;

@Service
@Transactional
public class RoomServiceServiceImpl implements RoomServiceService{
	
	@Autowired
	private RoomServiceDao roomServiceDao;
	
	@Override
	public List<RoomService> getAll() {		
		return roomServiceDao.findAll();
	}
	
	public RoomService findById(int id) {
		RoomService roomService =null;
		roomService = roomServiceDao.findById(id).get();
		return roomService;
	}
	
	
	public Response save(RoomService roomService) {
		roomServiceDao.save(roomService);		
		return new Response(true);
	}
	
	public Response checkOut(RoomService roomService) {
//		RoomService rs = roomServiceDao.findById(roomService.getId()).get();
//		rs.setStatus(2);
//		
		roomServiceDao.save(roomService);
		return new Response(true);
	}
	
	@Override
	public Response deleteById(int id) {
		
		RoomService roomService = roomServiceDao.findById(id).get();
		
		roomService.setStatus(0);
		roomServiceDao.save(roomService);
		
		return new Response(true);
	}

	
}
