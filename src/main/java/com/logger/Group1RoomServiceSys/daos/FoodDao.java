package com.logger.Group1RoomServiceSys.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logger.Group1RoomServiceSys.beans.Food;

public interface FoodDao extends JpaRepository<Food, Integer>{

}
