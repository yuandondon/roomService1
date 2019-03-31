package com.logger.Group1RoomServiceSys.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logger.Group1RoomServiceSys.beans.Food;
import com.logger.Group1RoomServiceSys.beans.RoomService;
import com.logger.Group1RoomServiceSys.daos.FoodDao;
import com.logger.Group1RoomServiceSys.daos.RoomServiceDao;
import com.logger.Group1RoomServiceSys.http.Response;
import com.logger.Group1RoomServiceSys.services.FoodService;

@Service
@Transactional
public class FoodServiceImpl implements FoodService{

	@Autowired
	FoodDao foodDao;
	
	
	@Override
	public List<Food> getAll() {		
		return foodDao.findAll();
	}
	
	public Response save(Food food) {
		foodDao.save(food);		
		return new Response(true);
	}
	
	@Override
	public Response deleteById(int id) {
		
		Food food =null;
		food = foodDao.findById(id).get();
		if(food !=null ) {
			foodDao.delete(food);
		}
		
		return new Response(true);
	}
	
}
