package com.logger.Group1RoomServiceSys.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logger.Group1RoomServiceSys.beans.FoodOrder;
import com.logger.Group1RoomServiceSys.daos.FoodOrderDao;
import com.logger.Group1RoomServiceSys.http.Response;

@Service
@Transactional
public class FoodOrderService {
	@Autowired
	FoodOrderDao foodOrderDao;
	
	
	
	public List<FoodOrder> getAll() {		
		return foodOrderDao.findAll();
	}
	
	public FoodOrder findById(int id) {
		FoodOrder foodOrder =null;
		foodOrder = foodOrderDao.findById(id).get();
		return foodOrder;
	}
	
	public Response save(FoodOrder foodOrder) {
		foodOrderDao.save(foodOrder);		
		return new Response(true);
	}
	
	public Response deleteById(int id) {
		
		FoodOrder foodOrder =null;
		foodOrder = foodOrderDao.findById(id).get();
		if(foodOrder !=null ) {
			foodOrderDao.delete(foodOrder);
		}
		
		return new Response(true);
	}
}
