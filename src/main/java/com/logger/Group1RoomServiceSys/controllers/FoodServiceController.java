package com.logger.Group1RoomServiceSys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logger.Group1RoomServiceSys.beans.Food;
import com.logger.Group1RoomServiceSys.http.Response;
import com.logger.Group1RoomServiceSys.services.FoodService;

@RestController
@RequestMapping("/food")
public class FoodServiceController {

	@Autowired
	FoodService foodService;
	
	@GetMapping
	public List<Food> getAll(){
		return foodService.getAll();	
	}
	
	@PostMapping("/add")
	public Response addRoomService(@RequestBody Food food) {
		System.out.println(food);
		return foodService.save(food);
	}
	
	@DeleteMapping("/{id}")
	//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
	public Response deleteRoomService(@PathVariable int id) {//, Authentication authentication) {
		return foodService.deleteById(id);
	}
}
