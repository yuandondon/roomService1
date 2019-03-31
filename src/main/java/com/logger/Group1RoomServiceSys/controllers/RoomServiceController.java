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

import com.logger.Group1RoomServiceSys.beans.RoomService;
import com.logger.Group1RoomServiceSys.beans.User;
import com.logger.Group1RoomServiceSys.http.Response;
import com.logger.Group1RoomServiceSys.services.RoomServiceService;

@RestController
@RequestMapping("/RoomService")
public class RoomServiceController {
	
	@Autowired
	RoomServiceService roomServiceService;
	
	@GetMapping
	public List<RoomService> getAll(){
		return roomServiceService.getAll();	
	}
	
	@PostMapping("/add")
	public Response addRoomService(@RequestBody RoomService roomService) {
		System.out.println(roomService);
		return roomServiceService.save(roomService);
	}
	
	@PostMapping("/checkout")
	public Response checkOutRoomService(@RequestBody RoomService roomService) {
		System.out.println(roomService);
		return roomServiceService.checkOut(roomService);
	}
	
	@DeleteMapping("/{id}")
	//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
	public Response deleteRoomService(@PathVariable int id) {//, Authentication authentication) {
		return roomServiceService.deleteById(id);
	}
}
