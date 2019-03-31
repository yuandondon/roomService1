package com.logger.Group1RoomServiceSys.services;

import java.util.List;

import com.logger.Group1RoomServiceSys.beans.Food;
import com.logger.Group1RoomServiceSys.http.Response;

public interface FoodService {

	List<Food> getAll();

	Response deleteById(int id);

	Response save(Food food);

}
