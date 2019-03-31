package com.logger.Group1RoomServiceSys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logger.Group1RoomServiceSys.beans.User;
import com.logger.Group1RoomServiceSys.http.Response;
import com.logger.Group1RoomServiceSys.services.UserService;

@RestController
@RequestMapping("/users")
public class UserServiceController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<User> getAll(){
		return userService.getAll();	
	}
	
	@GetMapping("/name/{name}")
	//@PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
	public User getByName(@PathVariable String name){
		return userService.getByName(name);
	}
	
	
	@PostMapping("/register")
	public Response addUser(@RequestBody User user) {
		System.out.println(user);
		return userService.save(user);
	}
	
	@PutMapping
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Response changeUserPassword(@RequestBody User user) {//, Authentication authentication) {
		return userService.changePassword(user);//, authentication);
	}
	
	@DeleteMapping("/{id}")
	//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
	public Response deleteUser(@PathVariable int id) {//, Authentication authentication) {
		return userService.deleteById(id);
	}
	
}
