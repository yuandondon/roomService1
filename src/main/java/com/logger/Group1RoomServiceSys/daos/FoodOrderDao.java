package com.logger.Group1RoomServiceSys.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logger.Group1RoomServiceSys.beans.FoodOrder;

public interface FoodOrderDao extends JpaRepository< FoodOrder, Integer>{

}
